package DBpersist;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.ycp.cs320.booksdb.model.Author;
import edu.ycp.cs320.booksdb.model.Book;
import edu.ycp.cs320.booksdb.model.Pair;
import edu.ycp.cs320.lab03.controller.Owner;
import edu.ycp.cs320.lab03.controller.Patron;
import edu.ycp.cs320.lab03.controller.Restaurant;
import edu.ycp.cs320.lab03.controller.User;

public class DerbyDatabase implements IDatabase {
	static {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (Exception e) {
			throw new IllegalStateException("Could not load Derby driver");
		}
	}

	private interface Transaction<ResultType> {
		public ResultType execute(Connection conn) throws SQLException;
	}

	private static final int MAX_ATTEMPTS = 10;

	@Override
	public List<Pair<Author, Book>> findBookByAuthorName(final String authorLast) {
		return executeTransaction(new Transaction<List<Pair<Author,Book>>>() {
			@Override
			public List<Pair<Author, Book>> execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;

				try {
					stmt = conn.prepareStatement(
							"select authors.*, books.* " +
									"  from authors, books " +
									"    where authors.author_id = books.author_id " +
									"        and authors.author_Lastname = ?"
							);
					stmt.setString(1, authorLast);

					List<Pair<Author, Book>> result = new ArrayList<Pair<Author,Book>>();

					resultSet = stmt.executeQuery();

					// for testing that a result was returned
					Boolean found = false;

					while (resultSet.next()) {
						found = true;

						Author author = new Author();
						loadAuthor(author, resultSet, 1);
						Book book = new Book();
						loadBook(book, resultSet, 4);

						result.add(new Pair<Author, Book>(author, book));
					}

					// check if the title was found
					if (!found) {
						System.out.println("<" + authorLast + "> was not found in the books table");
					}

					return result;


				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}

	@Override
	public List<Pair<Author, Book>> insertNewBook(final String title, final String authorLast, 
			final String authorFirst, final String isbn) {
		return executeTransaction(new Transaction<List<Pair<Author,Book>>>() {
			@Override
			public List<Pair<Author, Book>> execute(Connection conn) throws SQLException {
				PreparedStatement stmt1 = null;
				PreparedStatement stmt2 = null;
				PreparedStatement stmt3 = null;
				PreparedStatement stmt4 = null;
				PreparedStatement stmt5 = null;
				ResultSet resultSet1 = null;
				ResultSet resultSet2 = null;
				ResultSet resultSet3 = null;


				// connect to the database
				conn = DriverManager.getConnection("jdbc:derby:test.db;create=true");
				Integer author_id = -1;
//				Integer book_id = -1;
				try {
					conn.setAutoCommit(true);

					// prompt user for title to search for
					System.out.print("Lab 6 task 2 -> Author to find: ");

					// a canned query to find book information (including author name) from title
					stmt1 = conn.prepareStatement(
							"select author_id "
									+ "  from authors "
									+ "  where author_lastname = ? "
									+ "        and author_firstname= ? "
							);

					// substitute the title entered by the user for the placeholder in the query
					stmt1.setString(1, authorLast);
					stmt1.setString(2, authorFirst); 

					// execute the query
					resultSet1 = stmt1.executeQuery();

					if(resultSet1.next()){
						//the author was found
						author_id = resultSet1.getInt(1);
						System.out.println("author id-> " + author_id);


					}
					else{
						System.out.print("Adding Author ");
						// will add the names from previous input				
						stmt2 = conn.prepareStatement(
								" insert into authors(author_lastname, author_firstname) "
										+ " values(?,?) "
								);
						stmt2.setString(1, authorLast);
						stmt2.setString(2, authorFirst);
						stmt2.executeUpdate();	
						//ensure authors were added by seeing new author ID
						stmt3 = conn.prepareStatement(
								"select author_id "
										+ "  from authors "
										+ "  where author_lastname = ? "
										+ "        and author_firstname = ? "
								);
						stmt3.setString(1, authorLast);
						stmt3.setString(2, authorFirst);
						resultSet2 = stmt3.executeQuery();
						if(resultSet2.next()){
							author_id = resultSet2.getInt(1);
						}
						
						System.out.println("author id -> " + author_id);
					}

					//the author was found
					System.out.println("Author is in table");

					stmt4 = conn.prepareStatement(
							" insert into books(title, author_id, isbn) "
									+ " values(?, ?, ?) "

							);

					stmt4.setString(1, title);
					stmt4.setInt(2, author_id);
					stmt4.setString(3, isbn);
					stmt4.executeUpdate();


					List<Pair<Author, Book>> result = new ArrayList<Pair<Author,Book>>();

					stmt5 = conn.prepareStatement(
							" select authors.*, books.* " +
									" from authors, books " +
									" where books.title = ? " +
									" and authors.author_lastname = ? "
							);
					stmt5.setString(1, title);
					stmt5.setString(2, authorLast);

					resultSet3 = stmt5.executeQuery();

					// for testing that a result was returned
					Boolean found = false;

					while (resultSet3.next()) {
						found = true;
						Author author = new Author();
						loadAuthor(author, resultSet3, 1);
						Book book = new Book();
						loadBook(book, resultSet3, 4);
						result.add(new Pair<Author, Book>(author, book));
					}

					if (!found) {
						System.out.println("<" + title + "> was not found in the books table");
					}

					return result;

				} finally {
					// close result set, statement, connection
					DBUtil.closeQuietly(resultSet1);
					DBUtil.closeQuietly(resultSet2);
					DBUtil.closeQuietly(resultSet3);

					DBUtil.closeQuietly(stmt1);
					DBUtil.closeQuietly(stmt2);
					DBUtil.closeQuietly(stmt3);

					DBUtil.closeQuietly(conn);
				}
			}
		});

	}

	@Override
	public List<Pair<Author, Book>> findAuthorAndBookByTitle(final String title) {
		return executeTransaction(new Transaction<List<Pair<Author,Book>>>() {
			@Override
			public List<Pair<Author, Book>> execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;

				try {
					stmt = conn.prepareStatement(
							"select authors.*, books.* " +
									"  from authors, books " +
									" where authors.author_id = books.author_id " +
									"   and books.title = ?"
							);
					stmt.setString(1, title);

					List<Pair<Author, Book>> result = new ArrayList<Pair<Author,Book>>();

					resultSet = stmt.executeQuery();

					// for testing that a result was returned
					Boolean found = false;

					while (resultSet.next()) {
						found = true;

						Author author = new Author();
						loadAuthor(author, resultSet, 1);
						Book book = new Book();
						loadBook(book, resultSet, 4);

						result.add(new Pair<Author, Book>(author, book));
					}

					// check if the title was found
					if (!found) {
						System.out.println("<" + title + "> was not found in the books table");
					}

					return result;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}

	public<ResultType> ResultType executeTransaction(Transaction<ResultType> txn) {
		try {
			return doExecuteTransaction(txn);
		} catch (SQLException e) {
			throw new PersistenceException("Transaction failed", e);
		}
	}

	public<ResultType> ResultType doExecuteTransaction(Transaction<ResultType> txn) throws SQLException {
		Connection conn = connect();

		try {
			int numAttempts = 0;
			boolean success = false;
			ResultType result = null;

			while (!success && numAttempts < MAX_ATTEMPTS) {
				try {
					result = txn.execute(conn);
					conn.commit();
					success = true;
				} catch (SQLException e) {
					if (e.getSQLState() != null && e.getSQLState().equals("41000")) {
						// Deadlock: retry (unless max retry count has been reached)
						numAttempts++;
					} else {
						// Some other kind of SQLException
						throw e;
					}
				}
			}

			if (!success) {
				throw new SQLException("Transaction failed (too many retries)");
			}

			// Success!
			return result;
		} finally {
			DBUtil.closeQuietly(conn);
		}
	}

	private Connection connect() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:derby:test.db;create=true");

		// Set autocommit to false to allow multiple the execution of
		// multiple queries/statements as part of the same transaction.
		conn.setAutoCommit(false);

		return conn;
	}

	private void loadUser(User user, ResultSet resultSet, int index) throws SQLException {
		user.setUserId(resultSet.getInt(index++));
		user.setUserName(resultSet.getString(index++));
		user.setPassWord(resultSet.getString(index++));
	}

	private void loadOwner(Owner owner, ResultSet resultSet, int index) throws SQLException {
		owner.setOwnerId(resultSet.getInt(index++));
		owner.setUserId(resultSet.getInt(index++));
		owner.setFirstName(resultSet.getString(index++));
		owner.setPassWord(resultSet.getString(index++));
	}
	
	private void loadRestaurant(Restaurant rest, ResultSet resultSet, int index) throws SQLException {
		rest.setRestID(resultSet.getInt(index++));
		rest.setOwnerId(resultSet.getInt(index++));
		rest.setName(resultSet.getString(index++));
		rest.setAddress(resultSet.getString(index++));
		rest.setCity(resultSet.getString(index++));
		rest.setZipCode(resultSet.getString(index++));
	}
	
	private void loadPatron(Patron pat, ResultSet resultSet, int index) throws SQLException {
		pat.setPatronId(resultSet.getInt(index++));
		pat.setUserId(resultSet.getInt(index++));
		pat.setFirstName(resultSet.getString(index++));
		pat.setLastName(resultSet.getString(index++));
	}

	public void createTables() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				PreparedStatement stmt1 = null;
				PreparedStatement stmt2 = null;
				PreparedStatement stmt3 = null;
				PreparedStatement stmt4 = null;

				try {
					stmt1 = conn.prepareStatement(
							"create table users (" +
									"	user_id integer primary key " +
									"		generated always as identity (start with 1, increment by 1), " +									
									"	user_userName varchar(40)," +
									"	user_passWord varchar(40)" +
									")"
							);	
					stmt1.executeUpdate();

					stmt2 = conn.prepareStatement(
							"create table owners (" +
									"	owner_id integer primary key " +
									"		generated always as identity (start with 1, increment by 1), " +
									"	user_id integer constraint user_id references users, " +
									"	owner_lastName varchar(40)," +
									"	owner_firstName varchar(40)" +
									")"
							);
					stmt2.executeUpdate();
					
					stmt3 = conn.prepareStatement(
							"create table restuarants (" +
									"	rest_id integer primary key " +
									"		generated always as identity (start with 1, increment by 1), " +
									"	owner_id integer constraint owner_id references owners, " +
									"	rest_name varchar(40),"   +
									"	rest_address varchar(90)" +
									"   rest_city varchar(30)"	  +
									"   rest_zipcode varchar(10)" +
									")"
							);
					stmt3.executeUpdate();
					
					stmt4 = conn.prepareStatement(
							"create table patrons (" +
									"	patron_id integer primary key " +
									"		generated always as identity (start with 1, increment by 1), " +
									"	user_id integer constraint user_id references users, " +
									"	patron_lastName varchar(40)," +
									"	patron_firstName varchar(40)" +
									")"
							);
					stmt4.executeUpdate();

					return true;
				} finally {
					DBUtil.closeQuietly(stmt1);
					DBUtil.closeQuietly(stmt2);
					DBUtil.closeQuietly(stmt3);
					DBUtil.closeQuietly(stmt4);
				}
			}
		});
	}

	public void loadInitialData() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				List<Restaurant> restList;
				List<Owner> ownerList;
				List<Patron> patronList;
				List<User> userList;

				try {
					restList = InitialData.getRestaurants();
					ownerList = InitialData.getOwners();
					patronList = InitialData.getPatrons();
					userList = InitialData.getUsers();
				} catch (IOException e) {
					throw new SQLException("Couldn't read initial data", e);
				}

				PreparedStatement insertRestaurants = null;
				PreparedStatement insertOwners = null;
				PreparedStatement insertPatrons = null;
				PreparedStatement insertUsers = null;

				try {
					

					insertUsers = conn.prepareStatement("insert into users (user_id, user_userName, user_passWord) values (?, ?, ?)");
					for (User u : userList) {
						insertUsers.setInt(1, u.getUserId());
						insertUsers.setString(2, u.getUserName());
						insertUsers.setString(3, u.getPassWord());
						insertUsers.addBatch();
					}
					insertUsers.executeBatch();
					System.out.println("Users table populated");
					
					
					insertOwners = conn.prepareStatement("insert into owners (user_id, owner_id, owner_lastName, owner_Firstname) values (?, ?, ?, ?)");
					for (Owner owner : ownerList) {
						insertOwners.setInt(1, owner.getUserId());
						insertOwners.setInt(2, owner.getOwnerId());
						insertOwners.setString(3, owner.getLastName());
						insertOwners.setString(4, owner.getFirstName());
						insertOwners.addBatch();
					}
					insertOwners.executeBatch();
					System.out.println("Owners table populated");
					
					insertRestaurants = conn.prepareStatement("insert into restaurants (owner_id, rest_id, rest_name, rest_address, rest_city, rest_zipcode) "
																				+ "	values (?, ?, ?. ?, ?, ?)");
					for (Restaurant rest: restList) {
						insertRestaurants.setInt(1, rest.getOwnerId());
						insertRestaurants.setInt(2, rest.getRestID());
						insertRestaurants.setString(3,rest.getName());
						insertRestaurants.setString(4, rest.getAddress());
						insertRestaurants.setString(5, rest.getCity());
						insertRestaurants.setString(6, rest.getZipCode());
						insertRestaurants.addBatch();
					}
					insertRestaurants.executeBatch();
					System.out.println("restaurants table populated");
					
					
					insertPatrons = conn.prepareStatement("insert into patrons (user_id, patron_id, patron_lastName, pataron_firstName) values(?, ?, ?,)");
					for (Patron pat : patronList) {
						insertPatrons.setInt(1, pat.getUserId());
						insertPatrons.setInt(2, pat.getPatronId());
						insertPatrons.setString(3, pat.getLastName());
						insertPatrons.setString(4, pat.getFirstName());
						insertPatrons.addBatch();
					}
					insertPatrons.executeBatch();
					System.out.println("patron table populated");
					
					
					return true;
				} finally {
					DBUtil.closeQuietly(insertOwners);
					DBUtil.closeQuietly(insertRestaurants);
				}
			}
		});
	}

	// The main method creates the database tables and loads the initial data.
	public static void main(String[] args) throws IOException {
		System.out.println("Creating tables...");
		DerbyDatabase db = new DerbyDatabase();
		db.createTables();

		System.out.println("Loading initial data...");
		db.loadInitialData();

		System.out.println("Success!");
	}




}
