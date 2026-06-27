# NortheastInnovatorsMidterm

## Team Information
| Team Member | NUID | Assigned Role | Responsibilities |
|-------------|------|---------------|------------------|
| Nicholas Woodward | 002478780 | Student | README, Student Use Case Functionality |
| Meredith Molyneux| 003978998 | Faculty| XXXX |
| Ajay Alamuri | 003915177 | Admin | Formatting |

## Project Overview
The purpose of this project is to integrate a Digital University System with a role-based Access Control Layer to provide secure authentication and authorization for different university users. The application was developed using Java Swing and object-oriented programming principles to create a secure, modular, and user-friendly university management system.

The system implements role-based authentication and authorization to ensure that users can only access the features associated with their assigned role. Three primary use cases were implemented: Administrator, Faculty, and Student.

The Administrator module provides functionality to administer user accounts, register university personnel, manage student records, manage faculty records, and manage the administrator’s own profile. The Faculty module allows faculty members to manage courses, manage their profile, generate student performance reports, and view student academic information. The Student module enables students to manage coursework, register for classes, perform graduation audits, review transcripts, and manage their profile through secure authentication.

The project emphasizes secure access control, object-oriented software design, data validation, modular architecture, and intuitive user interface design while ensuring that each user can access only the functionality authorized for their role.

## Installation & Setup Instructions

### Prerequisites

Before running the project, make sure the following are installed:

- Java JDK 19
- NetBeans IDE
- Git
- Apache Ant

### Setup Instructions

1. Clone the GitHub repository:

```bash
git clone https://github.com/alamuri-a/NortheastInnovatorsMidterm.git
```

2. Open Apache NetBeans IDE.

3. Select **File → Open Project**.

4. Browse to the cloned `NortheastInnovatorsMidterm` project folder.

5. Click **Open Project**.

6. Right-click the project and select **Clean and Build**.

7. After the build completes successfully, right-click the project again and select **Run**.

8. The application will launch and display the login screen, where users can authenticate using their assigned credentials.

## Authentication & Access Control

The Digital University System implements a role-based Access Control Layer to provide secure authentication and authorization for all users. Every user must authenticate with a valid username and password before accessing the system.

After successful authentication, the system identifies the user's assigned role and grants access only to the corresponding work area. Unauthorized users are prevented from accessing features outside of their assigned permissions.

The implemented access control supports the following roles:

- **Administrator**
  - Administer user accounts
  - Register university personnel
  - Manage student records
  - Manage faculty records
  - View and manage administrator profile

- **Faculty**
  - Manage courses
  - View and manage faculty profile
  - Generate student performance reports
  - View student academic information

- **Student**
  - Manage coursework
  - Register for classes
  - Perform graduation audits
  - Review transcripts
  - View and manage student profile

Authentication is performed during the login process using the Access Control Layer. Authorization is enforced throughout the application by directing authenticated users to their assigned role-specific work area and preventing access to functionality assigned to other roles.

## Features Implemented

The Digital University System provides separate role-based work areas for Administrators, Faculty Members, and Students. Each work area contains functionality designed to support the responsibilities assigned to that role while enforcing secure access through the Access Control Layer.

### Administrator Features

The Administrator work area includes the following functionality:

- Secure administrator authentication
- Create, view, update, and delete user accounts
- Register university personnel
- Manage student records
- Manage faculty records
- View and manage administrator profile
- Role-based authorization for administrator-only features

### Faculty Features

The Faculty work area includes the following functionality:

- Secure faculty authentication
- View and manage faculty profile
- Manage assigned courses
- Generate student performance reports
- View student academic information

### Student Features

The Student work area includes the following functionality:

- Secure student authentication
- Student self-registration using a valid NUID
- View and manage student profile
- Register for classes
- Manage coursework
- Perform graduation audit
- Review academic transcript

### Access Control Features

The application includes the following security features:

- Username and password authentication
- Role-based authorization
- Separate work areas for each user role
- Validation of user credentials before access is granted
- Prevention of unauthorized access to protected functionality
- Automatic navigation to the appropriate work area after successful login

## Usage Instructions

After launching the application, users interact with the system according to their assigned role. The following steps describe the typical workflow for each user type.

### Administrator

1. Launch the application.
2. Log in using a valid administrator username and password.
3. Access the Administrator Work Area.
4. Administer user accounts by creating, viewing, updating, or deleting accounts.
5. Register new students, faculty members, and university employees.
6. Manage student and faculty records.
7. View and update the administrator profile.
8. Log out when finished.

### Faculty

1. Log in using valid faculty credentials.
2. Access the Faculty Work Area.
3. View and update faculty profile information.
4. Manage assigned courses.
5. Generate student performance reports.
6. View student academic information.
7. Log out when finished.

### Student

1. New students may register by selecting **Sign Up** and entering a valid NUID provided by the administrator.
2. Log in using the registered username and password.
3. Access the Student Work Area.
4. Manage coursework.
5. Register for or drop classes.
6. Perform a graduation audit.
7. Review the academic transcript.
8. View and update the student profile.
9. Log out when finished.

## Testing Guide

The following test cases were performed to verify that the application functions correctly and that authentication and authorization are properly enforced.

| Test Case | Expected Result |
|-----------|-----------------|
| Administrator login | Administrator successfully logs into the Administrator Work Area. |
| Faculty login | Faculty member successfully logs into the Faculty Work Area. |
| Student login | Student successfully logs into the Student Work Area. |
| Invalid username or password | User is denied access and an appropriate error message is displayed. |
| Administrator creates a user account | New user account is successfully created and stored in the system. |
| Administrator updates a user account | Changes are saved and displayed correctly. |
| Administrator deletes a user account | Selected user account is removed successfully. |
| Administrator registers a new student, faculty member, or employee | Personnel record is successfully created. |
| Student Sign-Up | Student successfully creates an account using a valid NUID. |
| Role-Based Authorization | Users are only able to access functionality assigned to their authenticated role. |
| Input Validation | Required fields and invalid inputs display appropriate validation messages. |
| Logout | User exits the current work area and returns to the login screen. |

Authentication and authorization were verified by confirming that each user role could access only its assigned work area and that unauthorized access to protected functionality was prevented.

## Challenges & Solutions

Throughout the development of this project, the team encountered several technical and implementation challenges while integrating the Digital University System with the Access Control Layer. The following table summarizes the major challenges encountered and the solutions implemented.

| Challenge | Solution |
|-----------|----------|
| TBD | TBD |
| TBD | TBD |
| TBD | TBD |
| TBD | TBD |

## Future Enhancements

The following enhancements could be implemented in future versions of the Digital University System:

- Integrate a relational database to replace in-memory data storage.
- Encrypt user passwords to improve application security.
- Implement password recovery and account management features.
- Add email notifications for registration and account updates.
- Expand reporting and analytics capabilities for administrators and faculty.
- Enhance the graphical user interface with improved navigation and accessibility.
- Implement audit logging to record user activity and administrative actions.
- Develop additional academic management features, including course scheduling and degree planning.

## Contribution Breakdown

The following table summarizes each team member's responsibilities and contributions to the project:

| Team Member | Assigned Use Case | Coding Contributions | Documentation | Testing | Other Contributions |
|-------------|-------------------|----------------------|---------------|---------|---------------------|
| Nicholas Woodward | Student | README, student-coursework, student-graduation-audit, student-manage-profile | TBD |   Tested Student UX | TBD |
| Meredith Molyneux | Faculty | TBD | TBD | TBD | TBD |
| Ajay Alamuri | Admin | Logout | TBD | TBD | TBD |

Each team member contributed to project planning, GitHub collaboration, code reviews, and integration testing throughout the development of the Digital University System.
