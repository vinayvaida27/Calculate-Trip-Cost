Calculate Trip Cost
Problem Statement : Calculate Trip Cost

Display total amount and charges per night for  3 holiday homes:
1. For 4 people in Nairobi from 15th Dec-2019 to 20th Dec-2019
2. Sort the list with highest traveler rating on top.
3.  Holiday home should have elevator/ List  access.
(Suggested Site: tripadvisor.in however  you are free to choose any other legitimate  site)+B6
Detailed Description: Hackath Ideas

1. Display Hotel name, total amount and charges per night for 3 holiday homes for 4 people in Nairobi for 5 days of stay from tomorrow's date; Should have sorted the list with highest traveler rating & should have elevator/ List  access
2 Pick one cruise line & pick a respective cruise ship under Cruises; 
                a. Retrieve all the languages offered and store in a List; Display the same
                b. Display passengers, crew & launched year
(Suggested Site: tripadvisor.in however  you are free to choose any other legitimate  site)

REFERENCE FOLDERS
1) Extented reports can be accessed from test-output folder under the name ExtentReport.html
2) Screenshots taken during test execution are stored in screenshot folder.
3) Input and Output datatables are stored in ExcelData folder.
4) Failed Screenshots taken during test execution are stored in failedScreenshot folder.

--------------------------------------------------------------------------------------------------------------------------------------

PRE-REQUISITES:

(1) Java version :jdk1.8
(2) Selenium version :3.141.59 jar
(3) TestNG version :7.3.0
(4) Apache Maven version : 3.6.3
(5) Apache POI version : 5.0.0
(6) Commons IO version :2.8.0
(7) Chrome browser version : 90.0.4430.24
(8) Firefox version : 88.0
(9) Edge Version : 90.0.818.56
(10) Jenkins Version : 2.277.3

---------------------------------------------------------------------------------------------------------------------------------------

STEPS TO EXECUTE THE FUNCTIONAL TEST CASES:
TS_01 Browsers:
(1) Check if Chrome Browser is opened in Windows Operating System.
(2) Check if Mozilla Browser is opened in Windows Operating System.
(3) Check if msEdge Browser is opened in Windows Operating System.

TS_02 Holiday Home Website:

(1) Broswser Should be opened.
(2) Go to the search bar.
(3) Type link "https://www.tripadvisor.in/" and press enter.
(4) Website should be opened
(5) Click the Search bar.
(6) Type "Nairobi".
(7) Select first option in the sugession list.
(8) Select the "Holiday homes" option.
(9) Select the Check-in date in the drop down calendar.
(10) Select the Check-out date in the drop down calendar.
(11) Select the no of Guests option.
(12) Increase to 4 in the guest option.
(13) Click Apply."
(14) Click the Amenities option.
(15) Click ""Show More"".
(16) Select Elevator/Lift access option."
(17) Select the "Sort By" drop down list box and select Travellers rating option.

TS_03	Cruise:

(1) Click on the "Cruise" option in menu bar.
(2) Go to the Cruise Line Drop down list box.
(3) Select ""A-ROSA Cruises"" option.
(4) Click the Search button."
(5) Go to the Cruise Line Drop down list box.
(6) Select ""A-ROSA Cruises"" option.
(7) Click the Search button."
(8) Click the drop down list box and select ""India""
(9) Select the respective currency of the country."
(10) Go to the Cruise Line Drop down list box.
(11) Select ""A-ROSA Cruises"" option.
(13) Click the Search button.
(14) Select the language button.
(15) Check the number of passengers, crew and year.

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
OUTPUT IN CHROME, FIREFOX AND EDGE

Name of the Hotel: Elegant Cosy Conquest
Price per night: ? 8,451
Total price: ? 42,257 / 5 nights

Name of the Hotel: City/River View Retreat in the Heart of Westlands
Price per night: ? 6,085
Total price: ? 30,425 / 5 nights

Name of the Hotel: The PINE LUSH -3 BDR (ALL ENSUITE) APARTMENT!2 MIN to SARIT CENTRE
Price per night: ? 12,846
Total price: ? 64,230 / 5 nights

Languages names in list:
United States
Canada (English)
Canada (français)
Brasil
México
Argentina
Chile
Colombia
Perú
Venezuela
United Kingdom
Italia
España
Deutschland
France
Sverige
Nederland
Türkiye
Danmark
Ireland
?eská republika
Österreich
??????
Suomi
Magyarország
Norge
Polska
Portugal
??????
Slovensko
Srbija
Schweiz
Suisse
Svizzera
Belgique
België
??
??
?????
India
Australia
Malaysia
New Zealand
Philippines
Singapore
Indonesia
????
???
Vi?t Nam
??
Hong Kong SAR
???????
???????
???
South Africa
?????

Passenger and crew details:
Passengers: 126   |   Crew: 36

Launch Year:
Launched: 2018   


















