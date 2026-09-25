import sys
import docx
from docx.shared import Pt
from docx.enum.text import WD_BREAK

doc = docx.Document()
doc.add_heading('FA23-BSE-056 - Lab 03 - SCD', 0)

# ==========================================
# TASK 01: SRS (Page 2 / Top of Document)
# ==========================================
doc.add_heading('Task 01: Software Requirements Specification (SRS)', level=1)

# Functional Requirements
doc.add_heading('1. Functional Requirements (FRs)', level=2)
frs = [
    "FR-01 (User Auth): The system must verify users via Email and WhatsApp OTP before account activation.",
    "FR-02 (Market Intelligence): The system must compute property demand scores using listing velocity and days-on-market.",
    "FR-03 (Targeted Scraping): The system must execute concurrent, multi-agent scrapers across 4 platforms using rotating proxy IPs.",
    "FR-04 (Seller Outreach): The system must generate and dispatch AI-drafted WhatsApp outreach messages via WABA templates.",
    "FR-05 (Seller Form): The system must dynamically render property-specific data collection forms and validate inputs.",
    "FR-06 (AI Analyzer): The system must use LLMs to generate market valuations and 150-word listing descriptions from form data.",
    "FR-07 (Buyer Outreach): The system must score scraped buyer leads using NLP and route high-intent WhatsApp replies to the seller.",
    "FR-08 (Listing Management): The system must publish verified, AI-enhanced properties to a public, searchable marketplace.",
    "FR-09 (Seller Dashboard): The system must provide sellers with a pipeline view of warm leads, closed deals, and revenue.",
    "FR-10 (Admin Control): The system must allow administrators to manage proxy pools, scraper health, and system APIs.",
    "FR-11 (Campaign Analytics): The system must track and display per-message delivery metrics for all WhatsApp campaigns.",
    "FR-12 (User Profiling): The system must allow buyers to configure property preferences for automated email alerts."
]
for fr in frs:
    doc.add_paragraph(fr, style='List Bullet')

# Non-Functional Requirements
doc.add_heading('2. Non-Functional Requirements (NFRs)', level=2)
nfrs = [
    "NFR-01 (Performance): Concurrent scraping tasks must run asynchronously via Celery and not block the main FastAPI web thread.",
    "NFR-02 (Security): All passwords and OTPs must be hashed using bcrypt. API keys must be strictly managed via environment variables and the admin panel.",
    "NFR-03 (Scalability): The scraping engine must support dynamic addition of proxy IPs to prevent target platform rate-limiting.",
    "NFR-04 (Reliability): WhatsApp webhook dispatchers must implement a 30-minute exponential backoff retry mechanism for failed network requests.",
    "NFR-05 (Usability): The Next.js frontend must implement strict role-based routing (Admin, Seller, Buyer) to guarantee isolated user experiences.",
    "NFR-06 (Compliance): The system must allow for complete anonymization of user data upon account deletion requests."
]
for nfr in nfrs:
    doc.add_paragraph(nfr, style='List Bullet')

# Use Cases
doc.add_heading('3. Use Cases', level=2)
uc_table = doc.add_table(rows=1, cols=4)
uc_table.style = 'Table Grid'
hdr = uc_table.rows[0].cells
hdr[0].text, hdr[1].text, hdr[2].text, hdr[3].text = 'Use Case ID', 'Use Case Name', 'Primary Actor', 'Description'

use_cases = [
    ['UC-01', 'Authenticate User', 'Any User', 'User registers, verifies identity via dual Email/WhatsApp OTP, and logs in securely.'],
    ['UC-02', 'Generate Market Intelligence', 'System', 'System automatically scrapes data to compute and display property demand scores.'],
    ['UC-03', 'Execute Targeted Scrape', 'Seller', 'Seller triggers multi-agent scrapers to fetch active listings matching specific property parameters.'],
    ['UC-04', 'Dispatch Seller Form', 'Seller', 'Seller approves and sends an automated WhatsApp message containing a link to a dynamic data collection form.'],
    ['UC-05', 'Analyze Property Data', 'System', 'System passes submitted form data to an LLM to generate a valuation estimate and listing description.'],
    ['UC-06', 'Run Buyer Campaign', 'Seller', 'Seller scores buyer leads via NLP, dispatches bulk WhatsApp templates, and monitors replies.'],
    ['UC-07', 'Manage Scraper Health', 'Admin', 'Admin monitors proxy IP blocks and manually pauses/restarts Celery scraping workers.'],
    ['UC-08', 'Browse Property Hub', 'Buyer', 'Buyer filters, searches, and bookmarks AI-verified properties on the public marketplace.']
]
for uc in use_cases:
    row = uc_table.add_row().cells
    row[0].text, row[1].text, row[2].text, row[3].text = uc[0], uc[1], uc[2], uc[3]

doc.add_page_break()

# ==========================================
# TASK 02: WBS, Backlogs & Prioritization
# ==========================================
doc.add_heading('Task 02: Work Breakdown & Backlog Management', level=1)

# WBS 1
doc.add_heading('Work Breakdown Structure (WBS) - Version 1', level=2)
t1 = doc.add_table(rows=1, cols=4)
t1.style = 'Table Grid'
h1 = t1.rows[0].cells
h1[0].text, h1[1].text, h1[2].text, h1[3].text = 'ID', 'Task Name', 'Days', 'Resources'
wbs1 = [
    ['1', 'SCOPE AND PLANNING', '17', ''],
    ['1.1', 'Competitor Analysis', '3', 'Mamoon, Muhammad'],
    ['1.2', 'Requirements Gathering', '8', 'Mamoon, Muhammad'],
    ['1.3', 'Scope Document Writing', '6', 'Mamoon, Muhammad'],
    ['2', 'SYSTEM DESIGN', '37', ''],
    ['2.1', 'Database Schema Design', '9', 'Muhammad Soban'],
    ['2.2', 'System Architecture & API', '9', 'Mamoon, Muhammad'],
    ['3', 'SOFTWARE REQUIREMENT SPEC (SRS)', '34', ''],
    ['3.1', 'Functional Requirements Docs', '7', 'Mamoon, Muhammad'],
    ['4', 'SOFTWARE DESIGN SPEC (SDS)', '24', ''],
    ['4.1', 'Architecture Component Design', '3', 'Mamoon, Muhammad'],
    ['5', 'DEVELOPMENT', '126', ''],
    ['5.1', 'Environment Setup', '4', 'Muhammad Soban'],
    ['5.2', 'M01 - User Authentication', '9', 'Muhammad Soban'],
    ['5.3', 'M02 - Market Intelligence Engine', '12', 'Muhammad Soban'],
    ['5.4', 'M03 - Scraping Engine', '22', 'Muhammad Soban'],
    ['6', 'TESTING', '15', ''],
    ['6.1', 'Unit test cases for all modules', '6', 'Mamoon, Muhammad'],
    ['7', 'FINAL REVIEW AND DELIVERY', '53', ''],
    ['7.1', 'Lead Scoring model evaluation', '5', 'Mamoon, Muhammad'],
    ['7.10', 'Project Complete', '1', 'Dr. Tehseen, Mamoon, Muhammad']
]
for row in wbs1:
    r = t1.add_row().cells
    r[0].text, r[1].text, r[2].text, r[3].text = row[0], row[1], row[2], row[3]

# WBS 2
doc.add_heading('Work Breakdown Structure (WBS) - Version 2 (Detailed)', level=2)
t2 = doc.add_table(rows=1, cols=4)
t2.style = 'Table Grid'
h2 = t2.rows[0].cells
h2[0].text, h2[1].text, h2[2].text, h2[3].text = 'ID', 'Task Name', 'Days', 'Resources'
wbs2_text = """1|Scope and Planning (Initiation)|17|Team
1.1|Competitor Analysis & Feasibility Study|3|Mamoon, Muhammad
1.1.1|Analyze Zameen, OLX, Graana, Ilaan|2|Mamoon, Muhammad
1.1.2|Conduct scraping feasibility tests|1|Muhammad
5|Development (Core Execution)|187|Team
5.2|M01 - User Authentication & Identity Verification|9|Muhammad
5.2.1|Dual-Channel OTP System (Email + WhatsApp)|3|Muhammad
5.2.2|Role-Based Access Control|3|Muhammad
5.2.3|JWT Session Management|3|Muhammad
5.4|M03 - Targeted Scraping Engine|22|Muhammad
5.4.1|Scrapy Spiders (Zameen, OLX)|6|Muhammad
5.4.2|Playwright Spiders (Graana, Ilaan)|6|Muhammad
5.4.3|Proxy Rotation & Rate Limiting System|5|Muhammad
5.4.4|Data Cleaning & Cross-Platform Deduplication|5|Muhammad
5.7|M07 - Buyer Outreach & Warm Lead Detection|28|Mamoon
5.7.1|Composite Lead Scoring Model (scikit-learn)|10|Mamoon
5.7.2|NLP Intent Classification (HOT/WARM/COLD)|10|Mamoon
5.7.3|Auto-follow-up Draft Generator|8|Mamoon"""
for line in wbs2_text.split('\n'):
    p = line.split('|')
    if len(p) == 4:
        r = t2.add_row().cells
        r[0].text, r[1].text, r[2].text, r[3].text = p[0], p[1], p[2], p[3]

# User Stories V1
doc.add_heading('User Stories - Version 1 (Epic Summary)', level=2)
doc.add_paragraph('US-1.01: As a new user, I want to verify my identity using both an Email and WhatsApp OTP.')
doc.add_paragraph('US-2.01: As the System, I need to concurrently scrape Zameen, OLX, Graana, and Ilaan using rotating proxies.')
doc.add_paragraph('US-3.01: As a Seller, I want the AI to analyze my form submission to generate a fair market valuation.')

# User Stories V2
doc.add_heading('User Stories - Version 2 (Exhaustive FE Mapping)', level=2)
doc.add_paragraph('Epic 1: User Authentication & Security')
doc.add_paragraph('US-1.01 (M01-FE1): As a new user, I want to submit a registration form so my data is validated by Zod.')
doc.add_paragraph('US-1.02 (M01-FE2): As the System, I need to generate a 6-digit email OTP, hash it with bcrypt, and dispatch via SendGrid.')
doc.add_paragraph('Epic 2: Targeted Scraping Engine')
doc.add_paragraph('US-2.04 (M03-FE4): As the Backend, I need Playwright spiders with randomized 3-7s delays and 13+ user-agent string rotations to scrape Graana.')
doc.add_paragraph('US-2.06 (M03-FE6): As the Data Pipeline, I need to deduplicate records using platform hashes and fuzzy matching.')
doc.add_paragraph('Epic 7: Buyer Outreach')
doc.add_paragraph('US-7.02 (M07-FE2): As the Scoring Engine, I need to pass scraped leads through Hugging Face NLP transformers to score buyer intent.')

# Comparison
doc.add_heading('Comparison: Version 2 vs Version 1', level=2)
doc.add_paragraph('Version 2 provides complete engineering traceability. Version 1 was designed purely as an "Agile Epic Summary" for non-technical stakeholders to grasp business value. Version 1 intentionally omitted backend system chores—like proxy rotation, webhook retries, and database deduplication. Version 2 captures these as strict "System Stories" required for sprint planning.')

# MoSCoW Prioritization
doc.add_heading('MoSCoW Prioritization & Justifications', level=2)
doc.add_paragraph('Must Have (M):', style='Heading 3')
doc.add_paragraph('- M01 Dual-OTP Auth: Platform trust collapses without identity verification.')
doc.add_paragraph('- M03 Targeted Scraping: The core data engine; no data means no product.')
doc.add_paragraph('- M06 AI Property Analyzer: The primary value proposition for sellers.')
doc.add_paragraph('Should Have (S):', style='Heading 3')
doc.add_paragraph('- M02 Market Intelligence: Highly useful for pricing, but outreach can survive without it temporarily.')
doc.add_paragraph('- M08 Listing Management: Secondary to the active WhatsApp outreach pipeline.')
doc.add_paragraph('Could Have (C):', style='Heading 3')
doc.add_paragraph('- M12 Saved Search Alerts: Nice engagement tool for buyers but not critical for MVP.')
doc.add_paragraph('Won\'t Have (W):', style='Heading 3')
doc.add_paragraph('- Payment Processing: Introduces legal/escrow overhead excluded from scope.')

# First Draft AI Missing
doc.add_heading('What a First-Draft AI Plan is Likely to Miss', level=2)
doc.add_paragraph('1. Anti-Bot Defenses: Generic AI assumes scraping is simple, missing the need for proxy IP rotation and Playwright vs Scrapy segregation.')
doc.add_paragraph('2. WhatsApp Constraints: Generic AI suggests dynamic outbound messages, ignoring Meta\'s strict WABA 24-72 hour pre-approved template requirement.')
doc.add_paragraph('3. Asynchronous Fragility: Generic AI ignores LLM token limits and timeout risks, missing the critical need for a Celery/Redis message broker with exponential backoff.')

doc.save('/home/soban-iftikhar/Projects/Java-SpringBoot-/FA23-BSE-056 - Lab 03 - SCD.docx')
