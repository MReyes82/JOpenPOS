#### Pending bugfixes

#### Pending features

[] FILES TO STORE EMPLOYEES CREDENTIALS: in the current implementation
there's only one valid user and password for both the employee and admin menu.
When at either the employee or admin login, it should receive the credentials
and look at the file where the employees credentials are stored to check if 
the user and password inputted is valid.
This function comes with the necessity for a specific file to store the usernames
for employees and a hashmap to store the respective password for the key (username).