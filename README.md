# Magazine Subscription Management Program Documentation

*Author: Justin Yeo Jun Neng*

*Version: June 18, 2023*

![JavaFX Logo](https://cdn.iconscout.com/icon/free/png-256/free-java-59-1174952.png?f=webp)

---

## Overview

This document provides an overview of the planning and development of user-defined classes for an online weekly personalized magazine service. The program aims to manage this service by offering customers a main magazine section along with additional supplements of their choice.

The document outlines various classes that have been created for this purpose, including the `Customer`, `PayingCustomer`, `AssociateCustomer`, `Magazine`, `Payment`, `Supplement`, `SupplementDatabase`, and `Helper` classes.

Referenced files: `Customer.java`, `PayingCustomer.java`, `AssociateCustomer.java`, `Magazine.java`, `Payment.java`, `Supplement.java`, `SupplementDatabase.java`, `Helper.java`, and `Main.java`.

### Requirements and Specification

The program facilitates the management of a magazine subscription system. Users can create a new magazine by specifying the main part cost and selecting supplements. Paying customers can be added with their name, email, and payment details, and associate customers can be associated with a paying customer. The program allows for the creation of multiple customers and the addition of associate customers. Magazine details, including the main part cost and selected supplements, can be initialized or created and displayed. Customers can be added to the magazine upon confirmation. On the flip side, the program also allows removal of customers from the created magazine. The program is also capable of generating weekly emails for each customer, and the contents of the email provide a list of interested supplements for customers, but omit the payment or invoicing. The invoice email is only generated through another method where it is only generated for Paying Customers. As such, the program streamlines the process of managing magazine subscriptions and customer interactions.

#### Assumptions

The program assumes valid user input and provides outputs confirming customer creation and successful customer removal from the magazine. The program assumes that there are no external factors or dependencies that may affect the program's functionality, such as network connectivity issues or external services required for payment processing. It assumes that the program can run independently without relying on external resources beyond what is provided within the code itself. Finally, the program also assumes that the main part cost of the magazine is user-defined and final, thus ignoring each individual supplement weekly cost.

---

## User Guide

| **Step** | **Action** | **Description** |
|----------|------------|-----------------|
| 1        | Open Apache NetBeans IDE | Open Apache NetBeans IDE 16. If not installed, download it from [here](https://netbeans.apache.org/download/nb17/index.html). |
| 1A       | Allow installation (macOS) | For macOS setup, allow installation by going to System Settings > Privacy & Security > Security > Click on "Allow applications downloaded from the App Store and identified developers." |
| 2        | Open project | After opening NetBeans, open the project through NetBeans: File > Open project > Left-click on the project. |
| 3        | Locate project file | Locate the project file ‘a2’ and click ‘Open Project.’ |
| 4        | Run the project | Right-click on ‘a2’ > Run > Output. The project is now running. |

**Generating Javadocs:**

1. Go to the top tabs and left-click on the run tab > ‘Generate Javadocs’. Output/Console will indicate ‘Build successful,’ and an HTML explorer will pop out with the Java documentation.

**Access generated Javadocs from directory:**

| **Step** | **Action** |
|----------|------------|
| 1        | Right-click on ‘Files’ tab | Right-click on the ‘Files’ tab in the project finder window in NetBeans. Locate ‘a2’ (Project name). |
| 2        | Expand project directories | Right-click on the arrow down on ‘dist’ to expand, then right-click on ‘javadoc’ to expand further. |
| 3        | Access index.html | Find ‘index.html,’ left-click on it, and right-click ‘View’. Your Javadocs will appear in an HTML browser. |

---

## Program Uses

The Magazine Subscription Management Program is designed to streamline the management of a magazine subscription system. It offers several key functionalities to enhance user experience and simplify magazine subscription management:

1. **Create and Customize Magazines:** Users can create new magazines, specifying the main part cost and selecting supplements to be included. This customization allows for tailored magazine offerings.

2. **Add Paying and Associate Customers:** Paying customers can be added with their essential details, including name, email, and payment information. Additionally, associate customers can be associated with paying customers, simplifying the tracking of customer relationships.

3. **Manage Customers and Subscriptions:** The program allows for the creation of multiple customers and the addition of associate customers. Customers can be added to the magazine, and the system confirms successful customer removal from the magazine.

4. **Email Notifications:** The program is capable of generating weekly emails for each customer. These emails include a list of supplements of interest but exclude payment or invoicing details. Payment invoices are generated separately and only for paying customers.

5. **Enhanced User Experience:** By automating customer interactions and magazine management, the program aims to enhance the user experience, reducing manual administrative tasks.

6. **Detailed Documentation:** The program provides JavaDocs, allowing users to access detailed documentation for code reference and understanding.

The Magazine Subscription Management Program simplifies the entire process of magazine subscription management, from magazine creation to customer management, email notifications, and documentation access. It is a valuable tool for businesses and individuals looking to efficiently manage magazine subscriptions while providing customization options for their customers.

