
package com.PomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomClass {

    public PomClass(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//h2[normalize-space()='CRM System']")
    public WebElement LoginPageTitle;

    @FindBy(xpath = "//input[@placeholder='Enter email']")
    public WebElement Email;

    @FindBy(xpath = "//input[@placeholder='Enter password']")
    public WebElement Password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginSubmitBtn;

    @FindBy(xpath = "//div[@id='51']")
    public WebElement Dashboard;

    @FindBy(xpath = "//section[@aria-label='Notifications Alt+T']//div[@role='alert']")
    public WebElement InvalidPassword;

    @FindBy(xpath = "//h2[normalize-space()='TotalLeads']")
    public WebElement TotalLeads;

    @FindBy(xpath = "//h2[normalize-space()='TotalCustomers']")
    public WebElement TotalCustomers;

    @FindBy(xpath = "//h2[normalize-space()='Total Department']")
    public WebElement TotalDepartment;

    @FindBy(xpath = "//h2[normalize-space()='Total Revenue']")
    public WebElement TotalRevenue;

    @FindBy(xpath = "//h2[normalize-space()='Conversion Rate']")
    public WebElement ConversionRate;

    @FindBy(xpath = "//h2[normalize-space()='Pending Payments']")
    public WebElement PendingPayments;

    @FindBy(xpath = "//h2[normalize-space()='Open Tickets']")
    public WebElement OpenTickets;

    @FindBy(xpath = "//h2[normalize-space()='Won Deals']")
    public WebElement WonDeals;
    
    @FindBy(xpath = "//input[@readonly]")
    public WebElement DateTable;
    
    @FindBy(xpath = "(//div[normalize-space()='25'])[2]")
    public WebElement DateDec26;

    @FindBy(xpath = "//h2[normalize-space()='Sales Trend - Yearly Revenue']")
    public WebElement SalesTrendYearlyRevenue;

    @FindBy(xpath = "//*[local-name()='tspan' and normalize-space(.)='2023']")
    public WebElement SalesYear2023;

    @FindBy(xpath = "//*[local-name()='tspan' and normalize-space(.)='2024']")
    public WebElement SalesYear2024;

    @FindBy(xpath = "//*[local-name()='tspan' and normalize-space(.)='2025']")
    public WebElement SalesYear2025;

    @FindBy(xpath = "//h2[normalize-space()='Lead Conversion']")
    public WebElement LeadConversion;

    @FindBy(xpath = "//span[contains(normalize-space(.),'% Rate')]")
    public WebElement LeadConversionRate;

    @FindBy(xpath = "//*[local-name()='text' and normalize-space(.)='New: 25%']")
    public WebElement LeadConversionNew;

    @FindBy(xpath = "//*[local-name()='text' and normalize-space(.)='Contacted: 25%']")
    public WebElement LeadConversionContacted;

    @FindBy(xpath = "//*[local-name()='text' and normalize-space(.)='Interested: 25%']")
    public WebElement LeadConversionInterested;

    @FindBy(xpath = "//*[local-name()='text' and normalize-space(.)='Not Interested: 12%']")
    public WebElement LeadConversionNotInterested;

    @FindBy(xpath = "//*[local-name()='text' and normalize-space(.)='Follow Up: 13%']")
    public WebElement LeadConversionFollowUp;

    @FindBy(xpath = "//h2[normalize-space()='Deal Pipeline']")
    public WebElement DealPipeline;

    @FindBy(xpath = "//*[local-name()='tspan' and normalize-space(.)='New']")
    public WebElement DealPipelineNew;

    @FindBy(xpath = "//*[local-name()='tspan' and normalize-space(.)='Proposal']")
    public WebElement DealPipelineProposal;

    @FindBy(xpath = "//*[local-name()='tspan' and normalize-space(.)='Negotiation']")
    public WebElement DealPipelineNegotiation;

    @FindBy(xpath = "//*[local-name()='tspan' and normalize-space(.)='Won']")
    public WebElement DealPipelineWon;

    @FindBy(xpath = "//h2[normalize-space()='Revenue by Category']")
    public WebElement RevenueByCategory;

    @FindBy(xpath = "//*[local-name()='text' and normalize-space(.)='Software: $45k']")
    public WebElement RevenueCategorySoftware;

    @FindBy(xpath = "//*[local-name()='text' and normalize-space(.)='Services: $28k']")
    public WebElement RevenueCategoryServices;

    @FindBy(xpath = "//*[local-name()='text' and normalize-space(.)='Support: $18k']")
    public WebElement RevenueCategorySupport;

    @FindBy(xpath = "//p[text()='User Management']")
    public WebElement UserManagementHeading;

    @FindBy(xpath = "//p[text()='Manage System Users And Permissions']")
    public WebElement UserManagementDescription;

    @FindBy(xpath = "(//button[@type='button'])[3]")
    public WebElement AddUserButton;

    @FindBy(xpath = "//input[@placeholder='Search leads by name, email']")
    public WebElement UserSearchField;

    @FindBy(xpath = "//select[.//option[normalize-space()='All User']]")
    public WebElement AllUserDropdown;

    @FindBy(xpath = "//th[.//div[contains(normalize-space(text()),'Username')]]")
    public WebElement UsernameColumn;

    @FindBy(xpath = "//h1[contains(normalize-space(.),'User')]")
    public WebElement UserCountHeading;

    @FindBy(xpath = "//th[.//div[contains(normalize-space(text()),'Mail Id')]]")
    public WebElement MailIdColumn;

    @FindBy(xpath = "//th[.//div[contains(normalize-space(text()),'Department')]]")
    public WebElement DepartmentColumn;

    @FindBy(xpath = "//th[.//div[contains(normalize-space(text()),'Status')]]")
    public WebElement StatusColumn;

    @FindBy(xpath = "//th[.//div[contains(normalize-space(text()),'Last Login')]]")
    public WebElement LastLoginColumn;

    @FindBy(xpath = "//th[.//div[contains(normalize-space(text()),'Actions')]]")
    public WebElement ActionsColumn;

    @FindBy(xpath = "//span[text()='SALES_EXECUTIVE']")
    public WebElement SalesExecutive;

    @FindBy(xpath = "//span[text()='MANAGER']")
    public WebElement Manager;

    @FindBy(xpath = "//span[text()='TELECALLER']")
    public WebElement Telecaller;

    @FindBy(xpath = "//span[text()='SUPPORT']")
    public WebElement Support;

    @FindBy(xpath = "//span[text()='ADMIN']")
    public WebElement Admin;

    @FindBy(xpath = "//span[text()='View']")
    public WebElement ViewAction;

    @FindBy(xpath = "//span[text()='Edit']")
    public WebElement EditAction;

    @FindBy(xpath = "(//div[contains(normalize-space(.),'Page') and contains(normalize-space(.),'of')])[12]")
    public WebElement UserPagination;

    @FindBy(xpath = "//select[.//option[@value='5'] and .//option[@value='10'] and .//option[@value='20'] and .//option[@value='50']]")
    public WebElement RecordsPerPageDropdown;

    @FindBy(xpath = "//button[text()='Prev']")
    public WebElement PreviousPageButton;

    @FindBy(xpath = "//button[text()='Next']")
    public WebElement NextPageButton;

    @FindBy(xpath = "((//div[contains(@class,'items-center')]/button))[4]")
    public WebElement FirstPageButton;

    @FindBy(xpath = "((//div[contains(@class,'items-center')]/button))[7]")
    public WebElement LastPageButton;

    @FindBy(xpath = "(//a[@href='/users'])[1]")
    public WebElement UsersMenu;

    @FindBy(xpath = "(//a[@href='/leads'])[1]")
    public WebElement LeadsMenu;

    @FindBy(xpath = "(//a[@href='/customers'])[1]")
    public WebElement CustomersMenu;

    @FindBy(xpath = "(//a[@href='/deals'])[1]")
    public WebElement DealsMenu;

    @FindBy(xpath = "(//a[@href='/quotations'])[1]")
    public WebElement QuotationsMenu;

    @FindBy(xpath = "(//a[@href='/orders'])[1]")
    public WebElement OrdersMenu;

    @FindBy(xpath = "(//a[@href='/invoices'])[1]")
    public WebElement InvoicesMenu;

    @FindBy(xpath = "(//a[@href='/payments'])[1]")
    public WebElement PaymentsMenu;

    @FindBy(xpath = "(//a[@href='/support'])[1]")
    public WebElement SupportMenu;

    @FindBy(xpath = "(//a[@href='/products'])[1]")
    public WebElement ProductsMenu;

    @FindBy(xpath = "(//a[@href='/reports'])[1]")
    public WebElement ReportsMenu;

    @FindBy(xpath = "//div[not(*) and starts-with(normalize-space(.),'Page ')]")
    public WebElement PaginationInfo;

    @FindBy(xpath = "//h1[normalize-space()='Lead Management']")
    public WebElement LeadManagementHeading;

    @FindBy(xpath = "//p[normalize-space()='Manage And Track Your Sales']")
    public WebElement LeadManagementDescription;

    @FindBy(xpath = "//button[normalize-space()='Export']")
    public WebElement LeadExportButton;

    @FindBy(xpath = "//button[normalize-space()='Add New Lead']")
    public WebElement AddNewLeadButton;

    @FindBy(xpath = "//h1[normalize-space()='NewLeads']")
    public WebElement LeadNewLeadsCard;

    @FindBy(xpath = "//h1[normalize-space()='Interested']")
    public WebElement LeadInterestedCard;

    @FindBy(xpath = "//h1[normalize-space()='Converted']")
    public WebElement LeadConvertedCard;

    @FindBy(xpath = "//h1[normalize-space()='TotalLeads']")
    public WebElement LeadTotalLeadsCard;

    @FindBy(xpath = "//input[@placeholder='Search leads by Name, Status...']")
    public WebElement LeadSearchField;

    @FindBy(xpath = "//select[.//option[normalize-space()='All Status'] and .//option[normalize-space()='FollowUp']]")
    public WebElement LeadStatusDropdown;

    @FindBy(xpath = "//h2[starts-with(normalize-space(.),'Leads (')]")
    public WebElement LeadListHeading;

    @FindBy(xpath = "//th[.//div[contains(normalize-space(text()),'Lead Name')]]")
    public WebElement LeadNameColumn;

    @FindBy(xpath = "//th[.//div[contains(normalize-space(text()),'Contact')]]")
    public WebElement LeadContactColumn;

    @FindBy(xpath = "//th[.//div[contains(normalize-space(text()),'Assigned To')]]")
    public WebElement LeadAssignedToColumn;

    @FindBy(xpath = "//th[.//div[contains(normalize-space(text()),'Status')]]")
    public WebElement LeadStatusColumn;

    @FindBy(xpath = "//th[.//div[contains(normalize-space(text()),'Follow Up')]]")
    public WebElement LeadFollowUpColumn;

    @FindBy(xpath = "//th[.//div[contains(normalize-space(text()),'Actions')]]")
    public WebElement LeadActionsColumn;

    @FindBy(xpath = "//h1[normalize-space()='Customer Management']")
    public WebElement CustomerManagementHeading;

    @FindBy(xpath = "//p[normalize-space()='Manage Customer Information And Relationships']")
    public WebElement CustomerManagementDescription;

    @FindBy(xpath = "//input[@placeholder='Search by name, email or phone ,companyname']")
    public WebElement CustomerSearchField;

    @FindBy(xpath = "//span[normalize-space()='Active']")
    public WebElement CustomerActiveCard;

    @FindBy(xpath = "//span[normalize-space()='InActive']")
    public WebElement CustomerInActiveCard;

    @FindBy(xpath = "//p[normalize-space()='Deal Pipeline']")
    public WebElement DealPipelineHeading;

    @FindBy(xpath = "//p[normalize-space()='Track and manage sales opportunities']")
    public WebElement DealPipelineDescription;

    @FindBy(xpath = "//button[normalize-space()='Add Deal']")
    public WebElement AddDealButton;

    @FindBy(xpath = "//h1[normalize-space()='Total Pipeline']")
    public WebElement DealTotalPipelineCard;

    @FindBy(xpath = "//h1[normalize-space()='Won Deals']")
    public WebElement DealWonDealsCard;

    @FindBy(xpath = "//h1[normalize-space()='Open Deals']")
    public WebElement DealOpenDealsCard;

    @FindBy(xpath = "//input[@placeholder='Search leads....']")
    public WebElement DealSearchField;

    @FindBy(xpath = "//select[.//option[normalize-space()='All Stages']]")
    public WebElement DealStageDropdown;

    @FindBy(xpath = "//p[starts-with(normalize-space(.),'New (')]")
    public WebElement DealNewStageColumn;

    @FindBy(xpath = "//p[starts-with(normalize-space(.),'Proposal (')]")
    public WebElement DealProposalStageColumn;

    @FindBy(xpath = "//p[starts-with(normalize-space(.),'Negotiation (')]")
    public WebElement DealNegotiationStageColumn;

    @FindBy(xpath = "//p[starts-with(normalize-space(.),'Won (')]")
    public WebElement DealWonStageColumn;

    @FindBy(xpath = "//p[starts-with(normalize-space(.),'Lost (')]")
    public WebElement DealLostStageColumn;

    @FindBy(xpath = "//p[normalize-space()='Quotation Management']")
    public WebElement QuotationManagementHeading;

    @FindBy(xpath = "//p[normalize-space()='Create and manage sales quotations']")
    public WebElement QuotationManagementDescription;

    @FindBy(xpath = "//button[normalize-space()='Create Quotation']")
    public WebElement CreateQuotationButton;

    @FindBy(xpath = "//input[@placeholder='Search quotations...']")
    public WebElement QuotationSearchField;

    @FindBy(xpath = "//select[.//option[normalize-space()='All Status'] and .//option[normalize-space()='Draft']]")
    public WebElement QuotationStatusDropdown;

    @FindBy(xpath = "//h1[starts-with(normalize-space(.),'Quotations (')]")
    public WebElement QuotationListHeading;

    @FindBy(xpath = "//th[.//div[contains(normalize-space(text()),'Sl No')]]")
    public WebElement QuotationSlNoColumn;

    @FindBy(xpath = "//th[.//div[contains(normalize-space(text()),'Customer')]]")
    public WebElement QuotationCustomerColumn;

    @FindBy(xpath = "//th[.//div[contains(normalize-space(text()),'Date')]]")
    public WebElement QuotationDateColumn;

    @FindBy(xpath = "//th[.//div[contains(normalize-space(text()),'Amount')]]")
    public WebElement QuotationAmountColumn;

    @FindBy(xpath = "//th[.//div[contains(normalize-space(text()),'Status')]]")
    public WebElement QuotationStatusColumn;

    @FindBy(xpath = "//th[.//div[contains(normalize-space(text()),'Valid Until')]]")
    public WebElement QuotationValidUntilColumn;

    @FindBy(xpath = "//th[.//div[contains(normalize-space(text()),'Actions')]]")
    public WebElement QuotationActionsColumn;

    @FindBy(xpath = "(//button[.//span[text()='View']])[1]")
    public WebElement QuotationViewAction;

    @FindBy(xpath = "(//button[.//span[text()='Approve']])[1]")
    public WebElement QuotationApproveAction;

    @FindBy(xpath = "(//button[.//span[text()='Reject']])[1]")
    public WebElement QuotationRejectAction;

    @FindBy(xpath = "(//button[.//span[text()='Create Order']])[1]")
    public WebElement QuotationCreateOrderAction;

    @FindBy(xpath = "//h1[normalize-space()='Order Management']")
    public WebElement OrderManagementHeading;

    @FindBy(xpath = "//h4[normalize-space()='Track and manage customer orders']")
    public WebElement OrderManagementDescription;

    @FindBy(xpath = "//input[@placeholder='Search Orders, Customers...']")
    public WebElement OrderSearchField;

    @FindBy(xpath = "//select[.//option[normalize-space()='All Status'] and .//option[normalize-space()='Processing']]")
    public WebElement OrderStatusDropdown;

    @FindBy(xpath = "//h4[normalize-space()='Orders']")
    public WebElement OrderListHeading;

    @FindBy(xpath = "//h1[normalize-space()='Invoice Management']")
    public WebElement InvoiceManagementHeading;

    @FindBy(xpath = "//h4[normalize-space()='Track invoices and payments']")
    public WebElement InvoiceManagementDescription;

    @FindBy(xpath = "//div[normalize-space()='Total Invoices']")
    public WebElement InvoiceTotalInvoicesCard;

    @FindBy(xpath = "//div[normalize-space()='Pending Amount']")
    public WebElement InvoicePendingAmountCard;

    @FindBy(xpath = "//div[normalize-space()='Paid Amount']")
    public WebElement InvoicePaidAmountCard;

    @FindBy(xpath = "//input[@placeholder='Search invoices, Customers...']")
    public WebElement InvoiceSearchField;

    @FindBy(xpath = "//select[.//option[normalize-space()='All Status'] and .//option[normalize-space()='overDue']]")
    public WebElement InvoiceStatusDropdown;

    @FindBy(xpath = "//h4[normalize-space()='Invoices']")
    public WebElement InvoiceListHeading;

    @FindBy(xpath = "//p[normalize-space()='Payment Management']")
    public WebElement PaymentManagementHeading;

    @FindBy(xpath = "//p[normalize-space()='Track and record customer payments']")
    public WebElement PaymentManagementDescription;

    @FindBy(xpath = "//button[normalize-space()='Record Payment']")
    public WebElement RecordPaymentButton;

    @FindBy(xpath = "//h1[normalize-space()='Total Received']")
    public WebElement PaymentTotalReceivedCard;

    @FindBy(xpath = "//h1[normalize-space()='Total Payments']")
    public WebElement PaymentTotalPaymentsCard;

    @FindBy(xpath = "//h1[normalize-space()='Pending Invoices']")
    public WebElement PaymentPendingInvoicesCard;

    @FindBy(xpath = "//input[@placeholder='Search Payments...']")
    public WebElement PaymentSearchField;

    @FindBy(xpath = "//select[.//option[normalize-space()='All Modes']]")
    public WebElement PaymentModeDropdown;

    @FindBy(xpath = "//h1[starts-with(normalize-space(.),'Payment History (')]")
    public WebElement PaymentListHeading;

    @FindBy(xpath = "//th[.//div[contains(normalize-space(text()),'Payment Id')]]")
    public WebElement PaymentIdColumn;

    @FindBy(xpath = "//th[.//div[contains(normalize-space(text()),'Customer')]]")
    public WebElement PaymentCustomerColumn;

    @FindBy(xpath = "//th[.//div[contains(normalize-space(text()),'Invoice Id')]]")
    public WebElement PaymentInvoiceIdColumn;

    @FindBy(xpath = "//th[.//div[contains(normalize-space(text()),'Date')]]")
    public WebElement PaymentDateColumn;

    @FindBy(xpath = "//th[.//div[contains(normalize-space(text()),'Amount')]]")
    public WebElement PaymentAmountColumn;

    @FindBy(xpath = "//th[.//div[contains(normalize-space(text()),'Mode')]]")
    public WebElement PaymentModeColumn;

    @FindBy(xpath = "//th[.//div[contains(normalize-space(text()),'Reference')]]")
    public WebElement PaymentReferenceColumn;

    @FindBy(xpath = "//th[.//div[contains(normalize-space(text()),'Status')]]")
    public WebElement PaymentStatusColumn;

    @FindBy(xpath = "//p[normalize-space()='SupportTickets']")
    public WebElement SupportTicketsHeading;

    @FindBy(xpath = "//p[normalize-space()='Manager Customer Support Requests']")
    public WebElement SupportTicketsDescription;

    @FindBy(xpath = "//button[normalize-space()='Create Ticket']")
    public WebElement CreateTicketButton;

    @FindBy(xpath = "//h1[normalize-space()='Open']")
    public WebElement TicketOpenCard;

    @FindBy(xpath = "//h1[normalize-space()='In Progress']")
    public WebElement TicketInProgressCard;

    @FindBy(xpath = "//h1[normalize-space()='Resolved']")
    public WebElement TicketResolvedCard;

    @FindBy(xpath = "//h1[normalize-space()='High Priority']")
    public WebElement TicketHighPriorityCard;

    @FindBy(xpath = "//input[@placeholder='Search tickets...']")
    public WebElement TicketSearchField;

    @FindBy(xpath = "//select[.//option[normalize-space()='All Status'] and .//option[normalize-space()='onhold']]")
    public WebElement TicketStatusDropdown;

    @FindBy(xpath = "//h1[starts-with(normalize-space(.),'Tickets (')]")
    public WebElement TicketListHeading;

    @FindBy(xpath = "//th[.//div[contains(normalize-space(text()),'SL.No')]]")
    public WebElement TicketSlNoColumn;

    @FindBy(xpath = "//th[.//div[contains(normalize-space(text()),'Customer')]]")
    public WebElement TicketCustomerColumn;

    @FindBy(xpath = "//th[.//div[contains(normalize-space(text()),'Description')]]")
    public WebElement TicketDescriptionColumn;

    @FindBy(xpath = "//th[.//div[contains(normalize-space(text()),'Category')]]")
    public WebElement TicketCategoryColumn;

    @FindBy(xpath = "//th[.//div[contains(normalize-space(text()),'Priority')]]")
    public WebElement TicketPriorityColumn;

    @FindBy(xpath = "//th[.//div[contains(normalize-space(text()),'Status')]]")
    public WebElement TicketStatusColumn;

    @FindBy(xpath = "//th[.//div[contains(normalize-space(text()),'Assigned To')]]")
    public WebElement TicketAssignedToColumn;

    @FindBy(xpath = "//th[.//div[contains(normalize-space(text()),'Actions')]]")
    public WebElement TicketActionsColumn;

    @FindBy(xpath = "//p[normalize-space()='Product Management']")
    public WebElement ProductManagementHeading;

    @FindBy(xpath = "//p[normalize-space()='Manage Products And Services']")
    public WebElement ProductManagementDescription;

    @FindBy(xpath = "//button[normalize-space()='Add New Product']")
    public WebElement AddNewProductButton;

    @FindBy(xpath = "//input[@placeholder='Search Product by product Name, Category']")
    public WebElement ProductSearchField;

    @FindBy(xpath = "//h1[normalize-space()='Reports & Analytics']")
    public WebElement ReportsHeading;

    @FindBy(xpath = "//p[normalize-space()='Bussiness Insights and Performance Metrics']")
    public WebElement ReportsDescription;

    @FindBy(xpath = "//button[normalize-space()='Overview']")
    public WebElement ReportOverviewTab;

    @FindBy(xpath = "//button[normalize-space()='Leads']")
    public WebElement ReportLeadsTab;

    @FindBy(xpath = "//button[normalize-space()='Sales']")
    public WebElement ReportSalesTab;

    @FindBy(xpath = "//button[normalize-space()='Support']")
    public WebElement ReportSupportTab;

    @FindBy(xpath = "//button[normalize-space()='Team']")
    public WebElement ReportTeamTab;

    @FindBy(xpath = "(//p[normalize-space()='Total Revenue'])[1]")
    public WebElement ReportTotalRevenueCard;

    @FindBy(xpath = "//p[normalize-space()='TotalCustomers']")
    public WebElement ReportTotalCustomersCard;

    @FindBy(xpath = "//p[normalize-space()='Conversion Rate']")
    public WebElement ReportConversionRateCard;

    @FindBy(xpath = "//p[normalize-space()='Active Tickets']")
    public WebElement ReportActiveTicketsCard;

    @FindBy(xpath = "//h2[normalize-space()='Sales Pipeline']")
    public WebElement ReportSalesPipelineSection;

    @FindBy(xpath = "//h2[normalize-space()='Financial Summary']")
    public WebElement ReportFinancialSummarySection;

}
