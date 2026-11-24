
Feature: Login Functionality

  Scenario Outline: Verify login with valid and invalid credentials

    Given User is on the CRM login page
    When User enters email "<email>"
    And User enters password "<password>"
    And User clicks on login button
    Then User should be navigated to the home page "<result>"

    Examples:
      | email                 | password   | result  |
      |                       | Vishwa@123 | invalid |
      | 123455                | Vishwa@123 | invalid |
      | @#$                   | CRM_Admin  | invalid |
      | abcds                 | demoPwd    | invalid |
      | vishwa.kiaq@gmail.com |            | invalid |
      | vishwa.kiaq@gmail.com | 1234       | invalid |
      | vishwa.kiaq@gmail.com | @#$5       | invalid |
      | vishwa.kiaq@gmail.com | bhdfa      | invalid |
      | random                | demoPwd    | invalid |
      | vishwa.kiaq@gmail.com | Vishwa@123 | valid   |



  Scenario: Verify date selection in Dashboard

    Given User is on the CRM Dashboard page
    When User clicks on the Date box
    And User selects the date "25.12.2026"
    
  Scenario: Verify Dashboard Overview Cards
    Then User should see the TotalLeads card    
    And User should see the TotalCustomers card   
    And User should see the Total Department card    
    And User should see the Total Revenue card     	 	
    And User should see the Conversion Rate card		
    And User should see the Pending Payments card		
    And User should see the Open Tickets card			
    And User should see the Won Deals card			

  Scenario: Verify Sales Trend Yearly Revenue Chart
    Then User should see the Sales Trend - Yearly Revenue chart			
    And User should see the year "2023" in the Sales Trend chart		
    And User should see the year "2024" in the Sales Trend chart			
    And User should see the year "2025" in the Sales Trend chart			

  Scenario: Verify Lead Conversion Chart
    Then User should see the Lead Conversion chart			
    And User should see the Lead Conversion Rate "1.0%"			
    And User should see the New category with "25%"			
    And User should see the Contacted category with "25%" 			
    And User should see the Interested category with "25%" 	 	
    And User should see the Not Interested category with "12%" 		   
    And User should see the Follow Up category with "13%"			

  Scenario: Verify Deal Pipeline Chart
    Then User should see the Deal Pipeline chart   	
    And User should see the New stage			
    And User should see the Proposal stage							
    And User should see the Negotiation stage		
    And User should see the Won stage		

  Scenario: Verify Revenue by Category Chart
    Then User should see the Revenue by Category chart  	
    And User should see the Software category with revenue "$45k"   		
    And User should see the Services category with revenue "$28k"			
    And User should see the Support category with revenue "$18k"      
    

  Scenario: Verify User Header
    Then User should see the User Management heading			
    And User should see the Manage System Users And Permissions description	 
    And User should see the Add User button			

  Scenario: Verify User Search Field
    Then User should see the User Search field		
    And User Search field should display the placeholder "Search leads by name, email"  

  Scenario: Verify User Status Filter
    Then User should see the All User dropdown		
    And All User should be selected by default		

  Scenario: Verify User List Table
    Then User should see the User list heading     
    And User list should display the total user count "8"   		   
    And User should see the Username column		
    And User should see the Mail Id column			
    And User should see the Department column			
    And User should see the Status column			
    And User should see the Last Login column			
    And User should see the Actions column			

  Scenario: Verify User Department Details
    Then User should see the "SALES_EXECUTIVE" department   
    And User should see the "MANAGER" department    		
    And User should see the "TELECALLER" department			
    And User should see the "SUPPORT" department			
    And User should see the "ADMIN" department				

  Scenario: Verify User Actions
    Then User should see the View action for user records  		
    And User should see the Edit action for user records		

  Scenario: Verify User Pagination
    Then User should see the Page 1 of 1 information        
    And User should see the Show 10 dropdown			
    And User should see the Prev button    			
    And User should see the Next button				
    And User should see the First Page button		
    And User should see the Last Page button		
  
    		
    		
Scenario: Verify Lead Header
    When User clicks on the Leads menu
    Then User should see the Lead Management page heading
    And User should see the page description "Manage And Track Your Sales"
    And User should see the Export button
    And User should see the Add New Lead button

  Scenario: Verify Lead Summary Cards
    Then User should see the NewLeads summary card
    And User should see the Interested summary card
    And User should see the Converted summary card
    And User should see the TotalLeads summary card

  Scenario: Verify Lead Search and Status Filter
    Then User should see the search field with placeholder "Search leads by Name, Status..."
    And User should see the Lead Status filter
    And Lead Status filter should have "All Status" selected by default

  Scenario: Verify Lead List Table
    Then User should see the Leads list heading
    And User should see the Lead Name column in the Leads table
    And User should see the Contact column in the Leads table
    And User should see the Assigned To column in the Leads table
    And User should see the Status column in the Leads table
    And User should see the Follow Up column in the Leads table
    And User should see the Actions column in the Leads table

  Scenario: Verify Lead Pagination
    Then User should see the pagination information
    And Records per page dropdown should display "Show 10"
    And User should see the Prev button
    And User should see the Next button


  Scenario: Verify Customer Header
    When User clicks on the Customers menu
    Then User should see the Customer Management page heading
    And User should see the page description "Manage Customer Information And Relationships"

  Scenario: Verify Customer Search and Status Cards
    Then User should see the search field with placeholder "Search by name, email or phone ,companyname"
    And User should see the Active summary card
    And User should see the InActive summary card


  Scenario: Verify Deal Header
    When User clicks on the Deals menu
    Then User should see the Deal Pipeline page heading
    And User should see the page description "Track and manage sales opportunities"
    And User should see the Add Deal button

  Scenario: Verify Deal Summary Cards
    Then User should see the Total Pipeline summary card
    And User should see the Won Deals summary card
    And User should see the Open Deals summary card

  Scenario: Verify Deal Search and Stage Filter
    Then User should see the search field with placeholder "Search leads...."
    And User should see the Deal Stage filter
    And Deal Stage filter should have "All Stages" selected by default

  Scenario: Verify Deal Stage Columns
    Then User should see the New stage column
    And User should see the Proposal stage column
    And User should see the Negotiation stage column
    And User should see the Won stage column
    And User should see the Lost stage column


  Scenario: Verify Quotation Header
    When User clicks on the Quotations menu
    Then User should see the Quotation Management page heading
    And User should see the page description "Create and manage sales quotations"
    And User should see the Create Quotation button

  Scenario: Verify Quotation Search and Status Filter
    Then User should see the search field with placeholder "Search quotations..."
    And User should see the Quotation Status filter
    And Quotation Status filter should have "All Status" selected by default

  Scenario: Verify Quotation List Table
    Then User should see the Quotations list heading
    And User should see the Sl No column in the Quotations table
    And User should see the Customer column in the Quotations table
    And User should see the Date column in the Quotations table
    And User should see the Amount column in the Quotations table
    And User should see the Status column in the Quotations table
    And User should see the Valid Until column in the Quotations table
    And User should see the Actions column in the Quotations table

  Scenario: Verify Quotation Actions
    Then User should see the View action for quotation records
    And User should see the Approve action for quotation records
    And User should see the Reject action for quotation records
    And User should see the Create Order action for quotation records

  Scenario: Verify Quotation Pagination
    Then User should see the pagination information
    And Records per page dropdown should display "Show 5"
    And User should see the Prev button
    And User should see the Next button


  Scenario: Verify Order Header
    When User clicks on the Orders menu
    Then User should see the Order Management page heading
    And User should see the page description "Track and manage customer orders"

  Scenario: Verify Order Search and Status Filter
    Then User should see the search field with placeholder "Search Orders, Customers..."
    And User should see the Order Status filter
    And Order Status filter should have "All Status" selected by default
    And User should see the Orders list heading


  Scenario: Verify Invoice Header
    When User clicks on the Invoices menu
    Then User should see the Invoice Management page heading
    And User should see the page description "Track invoices and payments"

  Scenario: Verify Invoice Summary Cards
    Then User should see the Total Invoices summary card
    And User should see the Pending Amount summary card
    And User should see the Paid Amount summary card

  Scenario: Verify Invoice Search and Status Filter
    Then User should see the search field with placeholder "Search invoices, Customers..."
    And User should see the Invoice Status filter
    And Invoice Status filter should have "All Status" selected by default
    And User should see the Invoices list heading


  Scenario: Verify Payment Header
    When User clicks on the Payments menu
    Then User should see the Payment Management page heading
    And User should see the page description "Track and record customer payments"
    And User should see the Record Payment button

  Scenario: Verify Payment Summary Cards
    Then User should see the Total Received summary card
    And User should see the Total Payments summary card
    And User should see the Pending Invoices summary card

  Scenario: Verify Payment Search and Mode Filter
    Then User should see the search field with placeholder "Search Payments..."
    And User should see the Payment Mode filter
    And Payment Mode filter should have "All Modes" selected by default

  Scenario: Verify Payment History Table
    Then User should see the Payment History list heading
    And User should see the Payment Id column in the Payments table
    And User should see the Customer column in the Payments table
    And User should see the Invoice Id column in the Payments table
    And User should see the Date column in the Payments table
    And User should see the Amount column in the Payments table
    And User should see the Mode column in the Payments table
    And User should see the Reference column in the Payments table
    And User should see the Status column in the Payments table

  Scenario: Verify Payment Pagination
    Then User should see the pagination information
    And Records per page dropdown should display "Show 10"
    And User should see the Prev button
    And User should see the Next button


  Scenario: Verify Support Header
    When User clicks on the Support menu
    Then User should see the SupportTickets page heading
    And User should see the page description "Manager Customer Support Requests"
    And User should see the Create Ticket button

  Scenario: Verify Support Summary Cards
    Then User should see the Open summary card
    And User should see the In Progress summary card
    And User should see the Resolved summary card
    And User should see the High Priority summary card

  Scenario: Verify Ticket Search and Status Filter
    Then User should see the search field with placeholder "Search tickets..."
    And User should see the Ticket Status filter
    And Ticket Status filter should have "All Status" selected by default

  Scenario: Verify Ticket List Table
    Then User should see the Tickets list heading
    And User should see the SL.No column in the Tickets table
    And User should see the Customer column in the Tickets table
    And User should see the Description column in the Tickets table
    And User should see the Category column in the Tickets table
    And User should see the Priority column in the Tickets table
    And User should see the Status column in the Tickets table
    And User should see the Assigned To column in the Tickets table
    And User should see the Actions column in the Tickets table

  Scenario: Verify Ticket Pagination
    Then User should see the pagination information
    And Records per page dropdown should display "Show 5"
    And User should see the Prev button
    And User should see the Next button


  Scenario: Verify Product Header
    When User clicks on the Products menu
    Then User should see the Product Management page heading
    And User should see the page description "Manage Products And Services"
    And User should see the Add New Product button
    And User should see the search field with placeholder "Search Product by product Name, Category"


  Scenario: Verify Reports Header
    When User clicks on the Reports menu
    Then User should see the Reports & Analytics page heading
    And User should see the page description "Bussiness Insights and Performance Metrics"

  Scenario: Verify Report Tabs
    Then User should see the Overview report tab
    And User should see the Leads report tab
    And User should see the Sales report tab
    And User should see the Support report tab
    And User should see the Team report tab

  Scenario: Verify Report Overview Cards
    Then User should see the Total Revenue summary card
    And User should see the TotalCustomers summary card
    And User should see the Conversion Rate summary card
    And User should see the Active Tickets summary card
    And User should see the Sales Pipeline section
    And User should see the Financial Summary section
    		