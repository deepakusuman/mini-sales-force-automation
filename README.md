# mini-sales-force-automation

A Software product and services company decided to invest in developing a Sales Force Automation solution that can be offered as an application to different corporate customers. The registration of corporate customers will be done via a separate system and it is not part of the scope of this project. The high level requirements of the Sales Force Automation solution are given below:

# Model Layer Features

The application should have the following Business Objects -

# # Opportunity
The Opportunity Business object should contain the attributes (fields) – Name , Win Percentage , Account , Primary Contact , Close Date , Estimated Revenue , Risk Level (High/Medium/Low)

# # Contact
The Contact Business Object should contain the attributes (fields) – Name , Account , Address , Title , Work Phone , Mobile Phone , Email

# # Relationships

There should also be an M:M relationship between Opportunity and Contact business object , where an Opportunity can be associated with multiple Contacts and a Contact can be involved in multiple Opportunities .

# UI Features

A user of the application should be able to perform the following actions -

1. Create new Opportunities.
2. Edit existing Opportunities.
3. Search for a specific Opportunity using Name or Account.
4. Delete Opportunities.
5. Create new Contacts
6. Edit existing Contacts
7. Search for specific Contact using Name or Email address
8. Delete Contacts.
9. Associate Multiple Contacts to Opportunities.
10. Set one of the associated Contacts as Primary Contacts.
