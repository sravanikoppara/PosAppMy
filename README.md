# PosAppMy

PosAppMy is a test automation assessment project built with Maven. It leverages Selenium and Java to create test automation scripts, using TestNG for reporting.

## Table of Contents

- [Installation](#installation)
:- [Usage](#usage):eclipse IDE
- [Running Tests](#running-tests): run or debug the file GoogleSearchTests.java
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

## Features
Test Case:1 
o Title: Verify that Pos website offers to buy Insurance.
o Test Steps:
▪ Go to pos.com.my
▪ Scroll down to the section “What can Pos Malaysia do for you,
today?” and click on the button “Buy Insurance”
Verify that a new page is open (in a new tab) and the new URL
destination is insurance.pos.com.my 
Verify that the button “I drive a car” and “I ride a motorcycle” can
be clicked. Once either of the buttons is clicked, it will show a new
section “Ok, let’s get to know you” and ask for five different fields.

Test Case 2:
o Title: Verify that the Pos website has links to create the e-Consignment note.
o Test Steps:
▪ Go to pos.com.my
▪ Click on the menu bar “Send” > “Parcel”.
On the new page (pos.com.my/send/send-parcel), scroll down and
click on the “Create shipment now” button under the Cash section:
▪ Verify that the new page loaded is the e-Consignment Note forms:
• URL should be https://send.pos.com.my/home/e-
connote?lg=en
• It should show Sender Info, Receiver Info, Parcel Info,
Summary sections:

## Requirements

- Java 8 or higher
- Maven 3.6.0 or higher

## Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/sravanikoppara/posAppMy.git
