# CS4125-Project Description V1.01

Required software: 

Eclipse IDE 

MySQL WorkBench or Xaamp to create DB to store user data. 

Make sure to import all correct packages in eclipse prior to working on project. 


# Users Class

Staff, Student and Guest. 

Student: Can create account, login and reserve a parking space. No discounts and eligible for penalty due to no-show.

Staff: Can create account, login and reserve a parking space. Eligible for staff discount.

Guest: Sponsored access only. Able to view available spaces. Cannot reserve. 

# Login Class

Facilitates login and reset password

Passes user credentials from Users class that are stored in DB during registration

Reset password button calls Reset Password function to email a reset link to email used to register.

# Reservation Class

Reserve parking space for: 1 hour, 2 hours or ALL day (24 hours) 
Filter spaces by category: Student or Staff (Colour coded, blue for staff, green for student)
Calls LiveCounter class to display parking space counter in real-time (refresh interval of 1 second)

# LiveCounter Class

Display current available spaces.

Counts available spaces by counting ALL Spaces offered - taken spaces = available spaces - store in int.

# Penalty Class

Count no-shows and add infraction to user in database e.g NAME: Ashutosh, EMAIL:XYZ@XYZ.com, PENALTYCOUNT: 1

If penaltyCount>3 && in 1 week 
        LogoutUser with message ("Too many no-shows this week, please come back in 1 week")
        
Apply penalty if space not available within designated time and apply monetary fee of 2 euro and store in penaltyAmount(int)

# Payment class

Pass 3 fields

Credit Card number as String 
CVV as string
Expiry date as string

Penalty amount: Call penaltyAmount(int) and display. 

# Added value

Create mobile application 

Add security aspect (2FA) Conall and Ash - verify user registration by sending an OTP via Email. 

# Added Link 
https://dev.mysql.com/downloads/connector/j/
https://dev.mysql.com/downloads/file/?id=507327

This .jar file is needed to access the DB 




