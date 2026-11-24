
package com.StepDefinition;

import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.BaseClass.BaseClass;
import com.PomClass.PomClass;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class StepDefinition extends BaseClass {

    PomClass p;


    @Before
    public void initializePOM() {
        p = new PomClass(driver);
    }



    @Given("User is on the CRM login page")
    public void user_is_on_the_crm_login_page() {

        wait.until(ExpectedConditions.visibilityOf(p.LoginPageTitle));

        Assert.assertTrue(isDisplayed(p.LoginPageTitle));
        Assert.assertTrue(isDisplayed(p.Email));
        Assert.assertTrue(isDisplayed(p.Password));
        Assert.assertTrue(isDisplayed(p.loginSubmitBtn));

    }


    @When("User enters email {string}")
    public void user_enters_email(String email) {

        wait.until(ExpectedConditions.visibilityOf(p.Email));
        clearText(p.Email);

        if (!email.isEmpty()) {
            sendKeys(p.Email, email);
        }

       
    }


    @When("User enters password {string}")
    public void user_enters_password(String password) {

        wait.until(ExpectedConditions.visibilityOf(p.Password));
        clearText(p.Password);

        if (!password.isEmpty()) {
            sendKeys(p.Password, password);
        }

        System.out.println("Password entered");
    }


    @When("User clicks on login button")
    public void user_clicks_on_login_button() {

        wait.until(ExpectedConditions.elementToBeClickable(p.loginSubmitBtn));
        click(p.loginSubmitBtn);
      
    }


    @Then("User should be navigated to the home page {string}")
    public void user_should_be_navigated_to_the_home_page(String result) {

        if (result.equalsIgnoreCase("valid")) {

            wait.until(ExpectedConditions.visibilityOf(p.Dashboard));

            Assert.assertTrue("Dashboard is not displayed",isDisplayed(p.Dashboard));

            
        }

        else if (result.equalsIgnoreCase("invalid")) {

            wait.until(d -> {

                boolean appError = p.InvalidPassword.isDisplayed();

                String emailValidation =
                        p.Email.getAttribute("validationMessage");

                String passwordValidation =
                        p.Password.getAttribute("validationMessage");

                return appError
                        || (emailValidation != null && !emailValidation.isEmpty())
                        || (passwordValidation != null && !passwordValidation.isEmpty());
            });

            boolean appError = p.InvalidPassword.isDisplayed();

            String emailValidation =
                    p.Email.getAttribute("validationMessage");

            String passwordValidation =
                    p.Password.getAttribute("validationMessage");

            boolean emailError =
                    emailValidation != null && !emailValidation.isEmpty();

            boolean passwordError =
                    passwordValidation != null && !passwordValidation.isEmpty();

            Assert.assertTrue(
                    "Expected login validation was not displayed",
                    appError || emailError || passwordError);

            if (appError) {
                System.out.println(
                        "Login failed - Application message: "
                                + getText(p.InvalidPassword));
            } else {
                System.out.println(
                        "Login failed - Browser required-field validation displayed");
            }
        }

        else {
            Assert.fail("Unknown login result: " + result);
        }
    }



    @Given("User is on the CRM Dashboard page")
    public void user_is_on_the_crm_dashboard_page() {

        wait.until(ExpectedConditions.visibilityOf(p.Dashboard));

        Assert.assertTrue(isDisplayed(p.Dashboard));

    }


    @When("User clicks on the Date box")
    public void user_clicks_on_the_date_box() {

        click(p.DateTable);

        
    }


    @When("User selects the date {string}")
    public void user_selects_the_date(String date) {

        click(p.DateDec26);

        
    }



    @Then("^User should see the (TotalLeads|TotalCustomers|Total Department|Total Revenue|Conversion Rate|Pending Payments|Open Tickets|Won Deals) card$")
    public void user_should_see_dashboard_card(String cardName) {

        switch (cardName) {

        case "TotalLeads":
            Assert.assertTrue(p.TotalLeads.isDisplayed());
            break;

        case "TotalCustomers":
            Assert.assertTrue(p.TotalCustomers.isDisplayed());
            break;

        case "Total Department":
            Assert.assertTrue(p.TotalDepartment.isDisplayed());
            break;

        case "Total Revenue":
            Assert.assertTrue(p.TotalRevenue.isDisplayed());
            break;

        case "Conversion Rate":
            Assert.assertTrue(p.ConversionRate.isDisplayed());
            break;

        case "Pending Payments":
            Assert.assertTrue(p.PendingPayments.isDisplayed());
            break;

        case "Open Tickets":
            Assert.assertTrue(p.OpenTickets.isDisplayed());
            break;

        case "Won Deals":
            Assert.assertTrue(p.WonDeals.isDisplayed());
            break;

        default:
            Assert.fail("Unknown Dashboard Card: " + cardName);
        }

        System.out.println(cardName + " card displayed");
    }



    @Then("User should see the Sales Trend - Yearly Revenue chart")
    public void user_should_see_sales_trend_chart() {

        Assert.assertTrue(p.SalesTrendYearlyRevenue.isDisplayed());

        System.out.println("Sales Trend chart displayed");
    }


    @Then("User should see the year {string} in the Sales Trend chart")
    public void user_should_see_year_in_sales_trend_chart(String year) {

        switch (year) {

        case "2023":
            Assert.assertEquals(year, p.SalesYear2023.getText().trim());
            break;

        case "2024":
            Assert.assertEquals(year, p.SalesYear2024.getText().trim());
            break;

        case "2025":
            Assert.assertEquals(year, p.SalesYear2025.getText().trim());
            break;

        default:
            Assert.fail("Invalid Sales Trend year: " + year);
        }

        System.out.println("Sales Trend Year validated: " + year);
    }



    @Then("User should see the Lead Conversion chart")
    public void user_should_see_lead_conversion_chart() {

        Assert.assertTrue(p.LeadConversion.isDisplayed());

        
    }


    @Then("User should see the Lead Conversion Rate {string}")
    public void user_should_see_lead_conversion_rate(String rate) {

        Assert.assertTrue(p.LeadConversionRate.isDisplayed());

        String actualRate = p.LeadConversionRate.getText().trim();

        Assert.assertTrue(
                "Expected Rate: " + rate + ", Actual Rate: " + actualRate,
                actualRate.contains(rate));

        System.out.println("Lead Conversion Rate: " + actualRate);
    }


    @Then("^User should see the (New|Contacted|Interested|Not Interested|Follow Up) category with \"(.*)\"$")
    public void user_should_see_lead_conversion_category(
            String category, String percentage) {

        String expectedText = category + ": " + percentage;

        switch (category) {

        case "New":
            Assert.assertEquals(expectedText,
                    p.LeadConversionNew.getText().trim());
            break;

        case "Contacted":
            Assert.assertEquals(expectedText,
                    p.LeadConversionContacted.getText().trim());
            break;

        case "Interested":
            Assert.assertEquals(expectedText,
                    p.LeadConversionInterested.getText().trim());
            break;

        case "Not Interested":
            Assert.assertEquals(expectedText,
                    p.LeadConversionNotInterested.getText().trim());
            break;

        case "Follow Up":
            Assert.assertEquals(expectedText,
                    p.LeadConversionFollowUp.getText().trim());
            break;

        default:
            Assert.fail("Unknown Lead Category: " + category);
        }

        System.out.println(category + " category validated");
    }


    @Then("User should see the Deal Pipeline chart")
    public void user_should_see_deal_pipeline_chart() {

        Assert.assertTrue(p.DealPipeline.isDisplayed());

        System.out.println("Deal Pipeline chart displayed");
    }


    @Then("^User should see the (New|Proposal|Negotiation|Won) stage$")
    public void user_should_see_deal_pipeline_stage(String stage) {

        switch (stage) {

        case "New":
            Assert.assertTrue(p.DealPipelineNew.isDisplayed());
            break;

        case "Proposal":
            Assert.assertTrue(p.DealPipelineProposal.isDisplayed());
            break;

        case "Negotiation":
            Assert.assertTrue(p.DealPipelineNegotiation.isDisplayed());
            break;

        case "Won":
            Assert.assertTrue(p.DealPipelineWon.isDisplayed());
            break;

        default:
            Assert.fail("Unknown Deal Pipeline Stage: " + stage);
        }

        System.out.println(stage + " stage displayed");
    }


    @Then("User should see the Revenue by Category chart")
    public void user_should_see_revenue_by_category_chart() {

        Assert.assertTrue(p.RevenueByCategory.isDisplayed());

        System.out.println("Revenue by Category chart displayed");
    }


    @Then("^User should see the (Software|Services|Support) category with revenue \"(.*)\"$")
    public void user_should_see_revenue_category(
            String category, String revenue) {

        String expectedText = category + ": " + revenue;

        switch (category) {

        case "Software":
            Assert.assertEquals(expectedText,
                    p.RevenueCategorySoftware.getText().trim());
            break;

        case "Services":
            Assert.assertEquals(expectedText,
                    p.RevenueCategoryServices.getText().trim());
            break;

        case "Support":
            Assert.assertEquals(expectedText,
                    p.RevenueCategorySupport.getText().trim());
            break;

        default:
            Assert.fail("Unknown Revenue Category: " + category);
        }

        System.out.println(category + " revenue validated");
    }


    @Then("User should see the User Management heading")
    public void user_should_see_user_management_heading() {

        Assert.assertTrue(p.UserManagementHeading.isDisplayed());

        System.out.println("User Management heading displayed");
    }


    @Then("User should see the Manage System Users And Permissions description")
    public void user_should_see_user_management_description() {

        Assert.assertTrue(p.UserManagementDescription.isDisplayed());

        System.out.println("User Management description displayed");
    }


    @Then("User should see the Add User button")
    public void user_should_see_add_user_button() {

        Assert.assertTrue(p.AddUserButton.isDisplayed());

        System.out.println("Add User button displayed");
    }


    @Then("User should see the User Search field")
    public void user_should_see_user_search_field() {

        Assert.assertTrue(p.UserSearchField.isDisplayed());

        System.out.println("User Search field displayed");
    }


    @Then("User Search field should display the placeholder {string}")
    public void user_search_field_should_display_placeholder(String placeholder) {

        Assert.assertEquals(
                placeholder,
                p.UserSearchField.getAttribute("placeholder"));

        System.out.println("Search placeholder validated");
    }


    @Then("User should see the All User dropdown")
    public void user_should_see_all_user_dropdown() {

        Assert.assertTrue(p.AllUserDropdown.isDisplayed());

        System.out.println("All User dropdown displayed");
    }


    @Then("All User should be selected by default")
    public void all_user_should_be_selected_by_default() {

        Select dropdown = new Select(p.AllUserDropdown);

        String selectedOption =
                dropdown.getFirstSelectedOption().getText().trim();

        Assert.assertEquals("All User", selectedOption);

        System.out.println("Default filter validated: " + selectedOption);
    }


    @Then("User should see the User list heading")
    public void user_should_see_user_list_heading() {

        Assert.assertTrue(p.UsernameColumn.isDisplayed());

        System.out.println("User list heading displayed");
    }


    @Then("User list should display the total user count {string}")
    public void user_list_should_display_total_user_count(String count) {

        String actualText = p.UserCountHeading.getText().trim();

        Assert.assertTrue(
                "Expected user count: " + count + ", Actual: " + actualText,
                actualText.contains(count));

        System.out.println("User count validated: " + actualText);
    }


    @Then("^User should see the (Username|Mail Id|Department|Status|Last Login|Actions) column$")
    public void user_should_see_user_table_column(String column) {

        switch (column) {

        case "Username":
            Assert.assertTrue(p.UsernameColumn.isDisplayed());
            break;

        case "Mail Id":
            Assert.assertTrue(p.MailIdColumn.isDisplayed());
            break;

        case "Department":
            Assert.assertTrue(p.DepartmentColumn.isDisplayed());
            break;

        case "Status":
            Assert.assertTrue(p.StatusColumn.isDisplayed());
            break;

        case "Last Login":
            Assert.assertTrue(p.LastLoginColumn.isDisplayed());
            break;

        case "Actions":
            Assert.assertTrue(p.ActionsColumn.isDisplayed());
            break;

        default:
            Assert.fail("Unknown User Table Column: " + column);
        }

        System.out.println(column + " column displayed");
    }



    @Then("User should see the {string} department")
    public void user_should_see_user_department(String department) {

        switch (department) {

        case "SALES_EXECUTIVE":
            Assert.assertEquals(department,
                    p.SalesExecutive.getText().trim());
            break;

        case "MANAGER":
            Assert.assertEquals(department,
                    p.Manager.getText().trim());
            break;

        case "TELECALLER":
            Assert.assertEquals(department,
                    p.Telecaller.getText().trim());
            break;

        case "SUPPORT":
            Assert.assertEquals(department,
                    p.Support.getText().trim());
            break;

        case "ADMIN":
            Assert.assertEquals(department,
                    p.Admin.getText().trim());
            break;

        default:
            Assert.fail("Unknown Department: " + department);
        }

        System.out.println(department + " department displayed");
    }



    @Then("User should see the View action for user records")
    public void user_should_see_view_action() {

        Assert.assertTrue(p.ViewAction.isDisplayed());

        System.out.println("View action displayed");
    }


    @Then("User should see the Edit action for user records")
    public void user_should_see_edit_action() {

        Assert.assertTrue(p.EditAction.isDisplayed());

        System.out.println("Edit action displayed");
    }


    @Then("User should see the Page 1 of 1 information")
    public void user_should_see_page_1_of_1_information() {

        String actualText = p.UserPagination.getText()
                .replaceAll("\\s+", " ").trim();

        Assert.assertTrue(
                "Pagination information mismatch: " + actualText,
                actualText.contains("Page 1 of 1"));

        System.out.println("Pagination validated: " + actualText);
    }


    @Then("User should see the Show 10 dropdown")
    public void user_should_see_show_10_dropdown() {

        Assert.assertTrue(p.RecordsPerPageDropdown.isDisplayed());

        System.out.println("Show 10 dropdown displayed");
    }


    @Then("User should see the Prev button")
    public void user_should_see_prev_button() {

        Assert.assertTrue(p.PreviousPageButton.isDisplayed());

        System.out.println("Prev button displayed");
    }


    @Then("User should see the Next button")
    public void user_should_see_next_button() {

        Assert.assertTrue(p.NextPageButton.isDisplayed());

        System.out.println("Next button displayed");
    }


    @Then("User should see the First Page button")
    public void user_should_see_first_page_button() {

        Assert.assertTrue(p.FirstPageButton.isDisplayed());

        System.out.println("First Page button displayed");
    }


    @Then("User should see the Last Page button")
    public void user_should_see_last_page_button() {

        Assert.assertTrue(p.LastPageButton.isDisplayed());

        System.out.println("Last Page button displayed");
    }



    @When("^User clicks on the (Users|Leads|Customers|Deals|Quotations|Orders|Invoices|Payments|Support|Products|Reports) menu$")
    public void user_clicks_on_the_menu(String menu) {

        switch (menu) {

        case "Users":
            click(p.UsersMenu);
            break;

        case "Leads":
            click(p.LeadsMenu);
            break;

        case "Customers":
            click(p.CustomersMenu);
            break;

        case "Deals":
            click(p.DealsMenu);
            break;

        case "Quotations":
            click(p.QuotationsMenu);
            break;

        case "Orders":
            click(p.OrdersMenu);
            break;

        case "Invoices":
            click(p.InvoicesMenu);
            break;

        case "Payments":
            click(p.PaymentsMenu);
            break;

        case "Support":
            click(p.SupportMenu);
            break;

        case "Products":
            click(p.ProductsMenu);
            break;

        case "Reports":
            click(p.ReportsMenu);
            break;

        default:
            Assert.fail("Unknown Menu: " + menu);
        }

        waitForURL("/" + menu.toLowerCase());


        refreshPage();

        System.out.println(menu + " menu clicked");
    }



    @Then("^User should see the (Lead Management|Customer Management|Deal Pipeline|Quotation Management|Order Management|Invoice Management|Payment Management|SupportTickets|Product Management|Reports & Analytics) page heading$")
    public void user_should_see_module_page_heading(String heading) {

        switch (heading) {

        case "Lead Management":
            Assert.assertTrue(isDisplayed(p.LeadManagementHeading));
            break;

        case "Customer Management":
            Assert.assertTrue(isDisplayed(p.CustomerManagementHeading));
            break;

        case "Deal Pipeline":
            Assert.assertTrue(isDisplayed(p.DealPipelineHeading));
            break;

        case "Quotation Management":
            Assert.assertTrue(isDisplayed(p.QuotationManagementHeading));
            break;

        case "Order Management":
            Assert.assertTrue(isDisplayed(p.OrderManagementHeading));
            break;

        case "Invoice Management":
            Assert.assertTrue(isDisplayed(p.InvoiceManagementHeading));
            break;

        case "Payment Management":
            Assert.assertTrue(isDisplayed(p.PaymentManagementHeading));
            break;

        case "SupportTickets":
            Assert.assertTrue(isDisplayed(p.SupportTicketsHeading));
            break;

        case "Product Management":
            Assert.assertTrue(isDisplayed(p.ProductManagementHeading));
            break;

        case "Reports & Analytics":
            Assert.assertTrue(isDisplayed(p.ReportsHeading));
            break;

        default:
            Assert.fail("Unknown Page Heading: " + heading);
        }

        System.out.println(heading + " heading displayed");
    }


    @Then("User should see the page description {string}")
    public void user_should_see_page_description(String description) {

        switch (description) {

        case "Manage And Track Your Sales":
            Assert.assertEquals(description, getText(p.LeadManagementDescription).trim());
            break;

        case "Manage Customer Information And Relationships":
            Assert.assertEquals(description, getText(p.CustomerManagementDescription).trim());
            break;

        case "Track and manage sales opportunities":
            Assert.assertEquals(description, getText(p.DealPipelineDescription).trim());
            break;

        case "Create and manage sales quotations":
            Assert.assertEquals(description, getText(p.QuotationManagementDescription).trim());
            break;

        case "Track and manage customer orders":
            Assert.assertEquals(description, getText(p.OrderManagementDescription).trim());
            break;

        case "Track invoices and payments":
            Assert.assertEquals(description, getText(p.InvoiceManagementDescription).trim());
            break;

        case "Track and record customer payments":
            Assert.assertEquals(description, getText(p.PaymentManagementDescription).trim());
            break;

        case "Manager Customer Support Requests":
            Assert.assertEquals(description, getText(p.SupportTicketsDescription).trim());
            break;

        case "Manage Products And Services":
            Assert.assertEquals(description, getText(p.ProductManagementDescription).trim());
            break;

        case "Bussiness Insights and Performance Metrics":
            Assert.assertEquals(description, getText(p.ReportsDescription).trim());
            break;

        default:
            Assert.fail("Unknown Page Description: " + description);
        }

        System.out.println("Page description validated: " + description);
    }


    @Then("^User should see the (Export|Add New Lead|Add Deal|Create Quotation|Record Payment|Create Ticket|Add New Product) button$")
    public void user_should_see_module_button(String button) {

        switch (button) {

        case "Export":
            Assert.assertTrue(isDisplayed(p.LeadExportButton));
            break;

        case "Add New Lead":
            Assert.assertTrue(isDisplayed(p.AddNewLeadButton));
            break;

        case "Add Deal":
            Assert.assertTrue(isDisplayed(p.AddDealButton));
            break;

        case "Create Quotation":
            Assert.assertTrue(isDisplayed(p.CreateQuotationButton));
            break;

        case "Record Payment":
            Assert.assertTrue(isDisplayed(p.RecordPaymentButton));
            break;

        case "Create Ticket":
            Assert.assertTrue(isDisplayed(p.CreateTicketButton));
            break;

        case "Add New Product":
            Assert.assertTrue(isDisplayed(p.AddNewProductButton));
            break;

        default:
            Assert.fail("Unknown Button: " + button);
        }

        System.out.println(button + " button displayed");
    }


    @Then("^User should see the (NewLeads|Interested|Converted|TotalLeads|Active|InActive|Total Pipeline|Won Deals|Open Deals|Total Invoices|Pending Amount|Paid Amount|Total Received|Total Payments|Pending Invoices|Open|In Progress|Resolved|High Priority|Total Revenue|TotalCustomers|Conversion Rate|Active Tickets) summary card$")
    public void user_should_see_summary_card(String card) {

        switch (card) {

        case "NewLeads":
            Assert.assertTrue(isDisplayed(p.LeadNewLeadsCard));
            break;

        case "Interested":
            Assert.assertTrue(isDisplayed(p.LeadInterestedCard));
            break;

        case "Converted":
            Assert.assertTrue(isDisplayed(p.LeadConvertedCard));
            break;

        case "TotalLeads":
            Assert.assertTrue(isDisplayed(p.LeadTotalLeadsCard));
            break;

        case "Active":
            Assert.assertTrue(isDisplayed(p.CustomerActiveCard));
            break;

        case "InActive":
            Assert.assertTrue(isDisplayed(p.CustomerInActiveCard));
            break;

        case "Total Pipeline":
            Assert.assertTrue(isDisplayed(p.DealTotalPipelineCard));
            break;

        case "Won Deals":
            Assert.assertTrue(isDisplayed(p.DealWonDealsCard));
            break;

        case "Open Deals":
            Assert.assertTrue(isDisplayed(p.DealOpenDealsCard));
            break;

        case "Total Invoices":
            Assert.assertTrue(isDisplayed(p.InvoiceTotalInvoicesCard));
            break;

        case "Pending Amount":
            Assert.assertTrue(isDisplayed(p.InvoicePendingAmountCard));
            break;

        case "Paid Amount":
            Assert.assertTrue(isDisplayed(p.InvoicePaidAmountCard));
            break;

        case "Total Received":
            Assert.assertTrue(isDisplayed(p.PaymentTotalReceivedCard));
            break;

        case "Total Payments":
            Assert.assertTrue(isDisplayed(p.PaymentTotalPaymentsCard));
            break;

        case "Pending Invoices":
            Assert.assertTrue(isDisplayed(p.PaymentPendingInvoicesCard));
            break;

        case "Open":
            Assert.assertTrue(isDisplayed(p.TicketOpenCard));
            break;

        case "In Progress":
            Assert.assertTrue(isDisplayed(p.TicketInProgressCard));
            break;

        case "Resolved":
            Assert.assertTrue(isDisplayed(p.TicketResolvedCard));
            break;

        case "High Priority":
            Assert.assertTrue(isDisplayed(p.TicketHighPriorityCard));
            break;

        case "Total Revenue":
            Assert.assertTrue(isDisplayed(p.ReportTotalRevenueCard));
            break;

        case "TotalCustomers":
            Assert.assertTrue(isDisplayed(p.ReportTotalCustomersCard));
            break;

        case "Conversion Rate":
            Assert.assertTrue(isDisplayed(p.ReportConversionRateCard));
            break;

        case "Active Tickets":
            Assert.assertTrue(isDisplayed(p.ReportActiveTicketsCard));
            break;

        default:
            Assert.fail("Unknown Summary Card: " + card);
        }

        System.out.println(card + " summary card displayed");
    }



    @Then("User should see the search field with placeholder {string}")
    public void user_should_see_search_field_with_placeholder(String placeholder) {

        switch (placeholder) {

        case "Search leads by Name, Status...":
            Assert.assertEquals(placeholder, getAttribute(p.LeadSearchField, "placeholder"));
            break;

        case "Search by name, email or phone ,companyname":
            Assert.assertEquals(placeholder, getAttribute(p.CustomerSearchField, "placeholder"));
            break;

        case "Search leads....":
            Assert.assertEquals(placeholder, getAttribute(p.DealSearchField, "placeholder"));
            break;

        case "Search quotations...":
            Assert.assertEquals(placeholder, getAttribute(p.QuotationSearchField, "placeholder"));
            break;

        case "Search Orders, Customers...":
            Assert.assertEquals(placeholder, getAttribute(p.OrderSearchField, "placeholder"));
            break;

        case "Search invoices, Customers...":
            Assert.assertEquals(placeholder, getAttribute(p.InvoiceSearchField, "placeholder"));
            break;

        case "Search Payments...":
            Assert.assertEquals(placeholder, getAttribute(p.PaymentSearchField, "placeholder"));
            break;

        case "Search tickets...":
            Assert.assertEquals(placeholder, getAttribute(p.TicketSearchField, "placeholder"));
            break;

        case "Search Product by product Name, Category":
            Assert.assertEquals(placeholder, getAttribute(p.ProductSearchField, "placeholder"));
            break;

        default:
            Assert.fail("Unknown Search Placeholder: " + placeholder);
        }

        System.out.println("Search placeholder validated: " + placeholder);
    }



    @Then("^User should see the (Lead Status|Deal Stage|Quotation Status|Order Status|Invoice Status|Payment Mode|Ticket Status) filter$")
    public void user_should_see_module_filter(String filter) {

        switch (filter) {

        case "Lead Status":
            Assert.assertTrue(isDisplayed(p.LeadStatusDropdown));
            break;

        case "Deal Stage":
            Assert.assertTrue(isDisplayed(p.DealStageDropdown));
            break;

        case "Quotation Status":
            Assert.assertTrue(isDisplayed(p.QuotationStatusDropdown));
            break;

        case "Order Status":
            Assert.assertTrue(isDisplayed(p.OrderStatusDropdown));
            break;

        case "Invoice Status":
            Assert.assertTrue(isDisplayed(p.InvoiceStatusDropdown));
            break;

        case "Payment Mode":
            Assert.assertTrue(isDisplayed(p.PaymentModeDropdown));
            break;

        case "Ticket Status":
            Assert.assertTrue(isDisplayed(p.TicketStatusDropdown));
            break;

        default:
            Assert.fail("Unknown Filter: " + filter);
        }

        System.out.println(filter + " filter displayed");
    }


    @Then("^(Lead Status|Deal Stage|Quotation Status|Order Status|Invoice Status|Payment Mode|Ticket Status) filter should have \"(.*)\" selected by default$")
    public void module_filter_should_have_default_option(String filter, String option) {

        Select dropdown = null;

        switch (filter) {

        case "Lead Status":
            dropdown = new Select(p.LeadStatusDropdown);
            break;

        case "Deal Stage":
            dropdown = new Select(p.DealStageDropdown);
            break;

        case "Quotation Status":
            dropdown = new Select(p.QuotationStatusDropdown);
            break;

        case "Order Status":
            dropdown = new Select(p.OrderStatusDropdown);
            break;

        case "Invoice Status":
            dropdown = new Select(p.InvoiceStatusDropdown);
            break;

        case "Payment Mode":
            dropdown = new Select(p.PaymentModeDropdown);
            break;

        case "Ticket Status":
            dropdown = new Select(p.TicketStatusDropdown);
            break;

        default:
            Assert.fail("Unknown Filter: " + filter);
        }

        String selectedOption =
                dropdown.getFirstSelectedOption().getText().trim();

        Assert.assertEquals(option, selectedOption);

        System.out.println(filter + " default validated: " + selectedOption);
    }



    @Then("^User should see the (Leads|Quotations|Orders|Invoices|Payment History|Tickets) list heading$")
    public void user_should_see_module_list_heading(String list) {

        switch (list) {

        case "Leads":
            Assert.assertTrue(isDisplayed(p.LeadListHeading));
            break;

        case "Quotations":
            Assert.assertTrue(isDisplayed(p.QuotationListHeading));
            break;

        case "Orders":
            Assert.assertTrue(isDisplayed(p.OrderListHeading));
            break;

        case "Invoices":
            Assert.assertTrue(isDisplayed(p.InvoiceListHeading));
            break;

        case "Payment History":
            Assert.assertTrue(isDisplayed(p.PaymentListHeading));
            break;

        case "Tickets":
            Assert.assertTrue(isDisplayed(p.TicketListHeading));
            break;

        default:
            Assert.fail("Unknown List Heading: " + list);
        }

        System.out.println(list + " list heading displayed");
    }


    @Then("^User should see the (.*) column in the (Leads|Quotations|Payments|Tickets) table$")
    public void user_should_see_column_in_module_table(String column, String table) {

        switch (table + ":" + column) {

        case "Leads:Lead Name":
            Assert.assertTrue(isDisplayed(p.LeadNameColumn));
            break;

        case "Leads:Contact":
            Assert.assertTrue(isDisplayed(p.LeadContactColumn));
            break;

        case "Leads:Assigned To":
            Assert.assertTrue(isDisplayed(p.LeadAssignedToColumn));
            break;

        case "Leads:Status":
            Assert.assertTrue(isDisplayed(p.LeadStatusColumn));
            break;

        case "Leads:Follow Up":
            Assert.assertTrue(isDisplayed(p.LeadFollowUpColumn));
            break;

        case "Leads:Actions":
            Assert.assertTrue(isDisplayed(p.LeadActionsColumn));
            break;

        case "Quotations:Sl No":
            Assert.assertTrue(isDisplayed(p.QuotationSlNoColumn));
            break;

        case "Quotations:Customer":
            Assert.assertTrue(isDisplayed(p.QuotationCustomerColumn));
            break;

        case "Quotations:Date":
            Assert.assertTrue(isDisplayed(p.QuotationDateColumn));
            break;

        case "Quotations:Amount":
            Assert.assertTrue(isDisplayed(p.QuotationAmountColumn));
            break;

        case "Quotations:Status":
            Assert.assertTrue(isDisplayed(p.QuotationStatusColumn));
            break;

        case "Quotations:Valid Until":
            Assert.assertTrue(isDisplayed(p.QuotationValidUntilColumn));
            break;

        case "Quotations:Actions":
            Assert.assertTrue(isDisplayed(p.QuotationActionsColumn));
            break;

        case "Payments:Payment Id":
            Assert.assertTrue(isDisplayed(p.PaymentIdColumn));
            break;

        case "Payments:Customer":
            Assert.assertTrue(isDisplayed(p.PaymentCustomerColumn));
            break;

        case "Payments:Invoice Id":
            Assert.assertTrue(isDisplayed(p.PaymentInvoiceIdColumn));
            break;

        case "Payments:Date":
            Assert.assertTrue(isDisplayed(p.PaymentDateColumn));
            break;

        case "Payments:Amount":
            Assert.assertTrue(isDisplayed(p.PaymentAmountColumn));
            break;

        case "Payments:Mode":
            Assert.assertTrue(isDisplayed(p.PaymentModeColumn));
            break;

        case "Payments:Reference":
            Assert.assertTrue(isDisplayed(p.PaymentReferenceColumn));
            break;

        case "Payments:Status":
            Assert.assertTrue(isDisplayed(p.PaymentStatusColumn));
            break;

        case "Tickets:SL.No":
            Assert.assertTrue(isDisplayed(p.TicketSlNoColumn));
            break;

        case "Tickets:Customer":
            Assert.assertTrue(isDisplayed(p.TicketCustomerColumn));
            break;

        case "Tickets:Description":
            Assert.assertTrue(isDisplayed(p.TicketDescriptionColumn));
            break;

        case "Tickets:Category":
            Assert.assertTrue(isDisplayed(p.TicketCategoryColumn));
            break;

        case "Tickets:Priority":
            Assert.assertTrue(isDisplayed(p.TicketPriorityColumn));
            break;

        case "Tickets:Status":
            Assert.assertTrue(isDisplayed(p.TicketStatusColumn));
            break;

        case "Tickets:Assigned To":
            Assert.assertTrue(isDisplayed(p.TicketAssignedToColumn));
            break;

        case "Tickets:Actions":
            Assert.assertTrue(isDisplayed(p.TicketActionsColumn));
            break;

        default:
            Assert.fail("Unknown Column: " + column + " in " + table + " table");
        }

        System.out.println(column + " column displayed in " + table + " table");
    }


    @Then("^User should see the (New|Proposal|Negotiation|Won|Lost) stage column$")
    public void user_should_see_deal_stage_column(String stage) {

        switch (stage) {

        case "New":
            Assert.assertTrue(isDisplayed(p.DealNewStageColumn));
            break;

        case "Proposal":
            Assert.assertTrue(isDisplayed(p.DealProposalStageColumn));
            break;

        case "Negotiation":
            Assert.assertTrue(isDisplayed(p.DealNegotiationStageColumn));
            break;

        case "Won":
            Assert.assertTrue(isDisplayed(p.DealWonStageColumn));
            break;

        case "Lost":
            Assert.assertTrue(isDisplayed(p.DealLostStageColumn));
            break;

        default:
            Assert.fail("Unknown Deal Stage: " + stage);
        }

        System.out.println(stage + " stage column displayed");
    }



    @Then("^User should see the (View|Approve|Reject|Create Order) action for quotation records$")
    public void user_should_see_quotation_action(String action) {

        switch (action) {

        case "View":
            Assert.assertTrue(isDisplayed(p.QuotationViewAction));
            break;

        case "Approve":
            Assert.assertTrue(isDisplayed(p.QuotationApproveAction));
            break;

        case "Reject":
            Assert.assertTrue(isDisplayed(p.QuotationRejectAction));
            break;

        case "Create Order":
            Assert.assertTrue(isDisplayed(p.QuotationCreateOrderAction));
            break;

        default:
            Assert.fail("Unknown Quotation Action: " + action);
        }

        System.out.println(action + " action displayed");
    }


    @Then("^User should see the (Overview|Leads|Sales|Support|Team) report tab$")
    public void user_should_see_report_tab(String tab) {

        switch (tab) {

        case "Overview":
            Assert.assertTrue(isDisplayed(p.ReportOverviewTab));
            break;

        case "Leads":
            Assert.assertTrue(isDisplayed(p.ReportLeadsTab));
            break;

        case "Sales":
            Assert.assertTrue(isDisplayed(p.ReportSalesTab));
            break;

        case "Support":
            Assert.assertTrue(isDisplayed(p.ReportSupportTab));
            break;

        case "Team":
            Assert.assertTrue(isDisplayed(p.ReportTeamTab));
            break;

        default:
            Assert.fail("Unknown Report Tab: " + tab);
        }

        System.out.println(tab + " report tab displayed");
    }


    @Then("^User should see the (Sales Pipeline|Financial Summary) section$")
    public void user_should_see_report_section(String section) {

        switch (section) {

        case "Sales Pipeline":
            Assert.assertTrue(isDisplayed(p.ReportSalesPipelineSection));
            break;

        case "Financial Summary":
            Assert.assertTrue(isDisplayed(p.ReportFinancialSummarySection));
            break;

        default:
            Assert.fail("Unknown Report Section: " + section);
        }

        System.out.println(section + " section displayed");
    }


    @Then("User should see the pagination information")
    public void user_should_see_pagination_information() {

        String actualText = getText(p.PaginationInfo)
                .replaceAll("\\s+", " ").trim();

        Assert.assertTrue(
                "Pagination information mismatch: " + actualText,
                actualText.matches("Page \\d+ of \\d+"));

        System.out.println("Pagination validated: " + actualText);
    }


    @Then("Records per page dropdown should display {string}")
    public void records_per_page_dropdown_should_display(String option) {

        Select dropdown = new Select(p.RecordsPerPageDropdown);

        String selectedOption =
                dropdown.getFirstSelectedOption().getText().trim();

        Assert.assertEquals(option, selectedOption);

        System.out.println("Records per page validated: " + selectedOption);
    }

}
