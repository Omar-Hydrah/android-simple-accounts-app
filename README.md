# android-simple-accounts-app
An android app to display and create user accounts. It uses "Room" (android.arch.persistence.room) for database operations.

## Activities:

- MainActivity 
        - Contains buttons to navigate to different activities.

- LoginActivity 
        - Checks user credentials against the database. The user then is redirected to MainActivity after a successful login

- RegisterActivity 
        - Creates a new user with a username, an email and a password. 
        - Informs the user, if the username already exists. 
        - It has a password and a password_confirm fields.

- UsersActivity 
        - Displays all registered users in a RecyclerView container.
