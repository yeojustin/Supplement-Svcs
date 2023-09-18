Author: Yeo Justin
Version: 3.1
Date: 29/07/2023
File Names: The main packages include controller, model, view, and templates with various class files inside.

![JavaFX Logo](https://upload.wikimedia.org/wikipedia/commons/3/30/JavaFX_text_logo.png)



## Statement of Purpose
🚀 The program provides functionalities for adding, deleting, and displaying details of customers, magazines, and supplements - you may see this as an extension to the non gui app version under supplement-svcs repo.

## Requirements

The program is designed to manage customers, magazines, and supplements. It includes options to:

- Add a new magazine or customer
- Delete a customer
- Display emails for all customers
- Display monthly emails for paying customers
- Manage supplements and their associations with magazines
- Handle different types of customers like paying and associate customers

## Structure

The project has a standard MVC structure with three main packages: controller, model, and view. Additionally, there's a module-info.java file, which contains the module information.

### Classes and Packages

**model Package**
- AssociateCustomer: This class represents an associate customer within the system.
- Customer: Base class representing a customer, with common attributes and methods for managing customers.
- Supplement: This class deals with supplements, possibly including information like name, cost, etc.
- Address: This class encapsulates the address details for customers or other entities.
- PayingCustomer: This class represents a customer who pays for services or products, extending the functionality of the Customer class.
- Magazine: This class handles magazine-related information, such as name, catalog, description, and supplements.

**view Package**
- CreateMode: This file likely contains code related to the creation mode of the application, possibly handling the user interface for creating new objects or entities.
- EditMode: This file probably contains code related to the editing mode of the application, possibly handling the user interface for editing existing objects or entities.

**controller Package**
- MagazineClient: The MagazineClient class acts as the main controller for managing customers, magazines, supplements, and interactions within the application. It includes functionalities for adding, deleting, and displaying details of customers, magazines, and supplements.
- EditControl: The EditControl class manages the relationships between magazines, customers, and supplements, handling the copying and synchronization of data related to these entities. It facilitates the display of various messages to customers based on subscriptions and interactions with magazines and supplements.

**template Package**
- There is a CustomerTemplate and SupplementTemplate abstract class that is used by the model classes. It provides flexibility in implementation and code reusability.


## Requirements and Specification

### Overview
The program serves as a management system for handling customers, magazines, supplements, and related interactions. It provides a set of functionalities for adding, deleting, displaying details of customers, magazines, and supplements, and managing interactions between these components.

### Main Functionalities

#### Magazine Management
- **Adding a New Magazine:** Allows the addition of new magazines with details like name, catalog, description, weekly cost, and associated supplements.
- **Supplement Management:** Supplements can be attached to magazines, with details like name and weekly cost.

#### Customer Management
- **Adding Multiple Customers:** Allows the addition of multiple customers with details like name, email, ID, gender, age, and associated supplements. Customers can be either paying customers or associate customers.
- **Deleting a Customer:** Enables the deletion of a customer by providing a specific customer ID.

#### Email and EditControl Management
- **Displaying Emails:** Offers functionalities to display emails for all customers for a given period (e.g., 4 weeks) or display monthly emails for paying customers.
- **Handling Replies:** Likely includes handling replies or responses related to user interactions, although the exact requirements need to be further explored.

### Assumptions and Conditions

#### Input Assumptions
- **Valid Customer Details:** When adding customers, valid details like name, email, ID, gender, and age must be provided.
- **Valid Supplement Details:** The supplements chosen by the customer must be valid and exist in the system.

#### Output Expectations
- **Informative Messages:** The program provides appropriate messages and prompts to guide the user through various functionalities.
- **Displaying Details:** The program displays details of magazines, customers, and interactions as required.

### Integration with Other Components

The MagazineClient class serves as the main controller, integrating and interacting with other classes (e.g., Magazine, Supplement, Customer, PayingCustomer, EditControl, AssociateCustomer) to achieve the desired functionalities.

## User Guide

| **Step** | **Action** | **Description** |
|----------|------------|-----------------|
| 1        | 🚀 Open up Apache NetBeans IDE 16 or 17 | Open Apache NetBeans IDE 16. If you have not downloaded the latest version of the IDE, please do so [here](https://netbeans.apache.org/download/nb17/index.html). |
| 1A       | ☑️ Allow installation (macOS) | For macOS setup, allow installation by going to System Settings > Privacy & Security > Security > Click on the option ”Allow applications downloaded from the App Store and identified developers.” |
| 2        | 📂 Open project | After opening NetBeans, open the project through NetBeans: File > Open project > Left-click on the project. |
| 3        | 🧭 Locate project file | After you click on it, locate the project file ‘a2’ and click ‘Open Project’. |
| 4        | ▶️ Run the project | Finally, right-click on ‘a2’ > Run > Output. Congratulations! The project is running now! |

**Generating Javadocs:**

1. Go to the top tabs and left-click on the run tab > ‘Generate Javadocs’.
   - Output/Console will indicate ‘Build successful,’ and an HTML explorer will pop out to bring you to the Java documentation.

**Access generated Javadocs from directory:**

| **Step** | **Action** |
|----------|------------|
| 1        | 📂 Right-click on the ‘Files’ tab | Right-click on the ‘Files’ tab in the project finder window on NetBeans. Locate ‘a2’ (Project name). |
| 2        | 📂 Right-click on arrow down on ‘dist’ to expand and right-click on ‘javadoc’ to expand. |
| 3        | 🕵️‍♂️ Find ‘index.html,’ left-click on it and right-click ‘View’. |
| 4        | 📖 Finally! Your javadocs will appear in an HTML browser |
