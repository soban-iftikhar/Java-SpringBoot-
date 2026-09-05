import os
import subprocess
import sys

def install_and_import():
    try:
        import docx
    except ImportError:
        subprocess.check_call([sys.executable, "-m", "pip", "install", "python-docx", "--quiet"])
        import docx
    return docx

docx = install_and_import()
from docx import Document

doc = docx.Document()
doc.add_heading('LEADS Project Documentation', 0)

# WBS V1
doc.add_heading('Work Breakdown Structure (WBS) - Version 1', level=1)
doc.add_paragraph('Extracted from the original Scope Document.')
t1 = doc.add_table(rows=1, cols=4)
t1.style = 'Table Grid'
hdr = t1.rows[0].cells
hdr[0].text, hdr[1].text, hdr[2].text, hdr[3].text = 'ID', 'Task Name', 'Days', 'Resources'
wbs1 = [
    ['1', 'SCOPE AND PLANNING', '17', ''],
    ['1.1', 'Competitor Analysis', '3', 'Mamoon Tahir, Muhammad Soban'],
    ['1.2', 'Requirements Gathering', '8', 'Mamoon Tahir, Muhammad Soban'],
    ['1.3', 'Scope Document Writing', '6', 'Mamoon Tahir, Muhammad Soban'],
    ['1.4', 'Scope Submitted', '1', 'Dr. Tehseen, Mamoon, Muhammad'],
    ['2', 'SYSTEM DESIGN', '37', ''],
    ['2.1', 'Database Schema Design', '9', 'Muhammad Soban'],
    ['2.2', 'System Architecture and API design', '9', 'Mamoon, Muhammad'],
    ['2.3', 'Lead-scoring model and NLP architecture', '7', 'Mamoon Tahir'],
    ['2.4', 'UI/UX wireframes', '14', 'Mamoon, Muhammad'],
    ['2.5', 'Design Phase Complete', '1', 'Dr. Tehseen, Mamoon, Muhammad'],
    ['3', 'SOFTWARE REQUIREMENT SPECIFICATION (SRS)', '34', ''],
    ['3.1', 'Functional Requirements Documentation', '7', 'Mamoon, Muhammad'],
    ['3.2', 'Non Functional Requirements Documentation', '3', 'Mamoon, Muhammad'],
    ['3.3', 'Usecase Diagrams and Descriptions', '9', 'Mamoon, Muhammad'],
    ['3.4', 'UML Diagrams', '9', 'Mamoon, Muhammad'],
    ['3.5', 'SRS Review and Finalization', '4', 'Dr. Tehseen, Mamoon, Muhammad'],
    ['3.6', 'SRS Complete', '1', 'Dr. Tehseen'],
    ['4', 'SOFTWARE DESIGN SPECIFICATION (SDS)', '24', ''],
    ['4.1', 'Architecture and Component Design', '3', 'Mamoon, Muhammad'],
    ['4.2', 'ER Diagram and Design Documentation', '12', 'Mamoon, Muhammad'],
    ['4.3', 'UML Diagrams', '7', 'Mamoon, Muhammad'],
    ['4.4', 'SDS Review and Finalization', '2', 'Dr. Tehseen, Mamoon, Muhammad'],
    ['4.5', 'SDS Complete', '1', 'Dr. Tehseen'],
    ['5', 'DEVELOPMENT', '126', ''],
    ['5.1', 'Environment Setup', '4', 'Muhammad Soban'],
    ['5.2', 'M01 - User Authentication', '9', 'Muhammad Soban'],
    ['5.3', 'M02 - Market Intelligence Engine', '12', 'Muhammad Soban'],
    ['5.4', 'M03 - Scraping Engine - Scrapy Spiders', '10', 'Muhammad Soban'],
    ['5.5', 'M03 - Scraping Engine - Playwright Spiders', '12', 'Muhammad Soban'],
    ['5.6', 'Scraping and Market Intelligence Complete', '1', 'Dr. Tehseen Riaz Abbasi'],
    ['5.7', 'M04 - Seller Outreach Agent', '9', 'Mamoon Tahir'],
    ['5.8', 'M05 - Seller Form System', '11', 'Mamoon Tahir'],
    ['5.9', 'M06 - AI Property Analyser', '10', 'Mamoon Tahir'],
    ['5.10', 'M07 Buyer Outreach - Lead Scoring model', '14', 'Mamoon Tahir'],
    ['5.11', 'M07 Buyer Outreach - Campaign dispatch + webhook', '14', 'Mamoon Tahir'],
    ['5.12', 'Seller Side Pipeline Complete', '1', 'Dr. Tehseen Riaz Abbasi'],
    ['5.13', 'M08 - Listing Management System - publish pipeline', '11', 'Muhammad Soban'],
    ['5.14', 'M08 - Listing Management System - Buyer Discovery UI', '9', 'Muhammad Soban'],
    ['5.15', 'M09 - Seller Dashboard', '8', 'Mamoon Tahir'],
    ['5.16', 'M10 - Admin Control Panel', '12', 'Muhammad Soban'],
    ['5.17', 'M11 - Campaign Dashboard', '8', 'Muhammad Soban'],
    ['5.18', 'M12 - Profile and Settings', '7', 'Mamoon Tahir'],
    ['5.19', 'Core Modules Development Complete', '1', 'Dr. Tehseen Riaz Abbasi'],
    ['5.20', 'Integration of all 12 modules into a unified system', '9', 'Mamoon, Muhammad'],
    ['5.21', 'End-to-end pipeline testing', '4', 'Mamoon, Muhammad'],
    ['5.22', '100% Working Product Complete', '1', 'Dr. Tehseen Riaz Abbasi'],
    ['6', 'TESTING', '15', ''],
    ['6.1', 'Unit test cases for all modules', '6', 'Mamoon, Muhammad'],
    ['6.2', 'Integration test plan (end-to-end pipeline)', '6', 'Mamoon, Muhammad'],
    ['6.3', 'Test results documentation and traceability matrix', '3', 'Mamoon, Muhammad'],
    ['6.4', 'Testing Document Complete', '1', 'Dr. Tehseen Riaz Abbasi'],
    ['7', 'FINAL REVIEW AND DELIVERY', '53', ''],
    ['7.1', 'Lead Scoring and reply-classification model evaluation', '5', 'Mamoon, Muhammad'],
    ['7.2', 'Performance optimization', '5', 'Mamoon, Muhammad'],
    ['7.3', 'Security Review', '5', 'Mamoon, Muhammad'],
    ['7.4', 'User Acceptance Testing', '8', 'Mamoon, Muhammad'],
    ['7.5', 'Bug fixing and final polishing', '4', 'Mamoon, Muhammad'],
    ['7.6', 'Final Report Writing', '9', 'Mamoon, Muhammad'],
    ['7.7', 'Final Presentation Preparation', '9', 'Dr. Tehseen, Mamoon, Muhammad'],
    ['7.8', 'Plagiarism Check', '1', 'Mamoon, Muhammad'],
    ['7.9', 'Final Evaluation and Presentation', '1', 'Mamoon, Muhammad'],
    ['7.10', 'Project Complete', '1', 'Dr. Tehseen, Mamoon, Muhammad']
]
for row in wbs1:
    r = t1.add_row().cells
    r[0].text, r[1].text, r[2].text, r[3].text = row[0], row[1], row[2], row[3]

doc.add_page_break()

# WBS V2
doc.add_heading('Work Breakdown Structure (WBS) - Version 2', level=1)
doc.add_paragraph('Detailed Level 3 breakdown mapped to engineering tasks.')
t2 = doc.add_table(rows=1, cols=4)
t2.style = 'Table Grid'
hdr2 = t2.rows[0].cells
hdr2[0].text, hdr2[1].text, hdr2[2].text, hdr2[3].text = 'ID', 'Task Name', 'Days', 'Resources'
wbs2_text = """1|Scope and Planning (Initiation)|17|Team
1.1|Competitor Analysis & Feasibility Study|3|Mamoon, Muhammad
1.1.1|Analyze Zameen, OLX, Graana, Ilaan|2|Mamoon, Muhammad
1.1.2|Conduct scraping feasibility tests|1|Muhammad
1.2|Requirements Gathering|8|Mamoon, Muhammad
1.2.1|Conduct structured interviews|4|Mamoon, Muhammad
1.2.2|Distribute and analyze buyer questionnaires|4|Mamoon, Muhammad
1.3|Scope Definition|6|Mamoon, Muhammad
1.4|Scope Finalization|1|Dr. Tehseen, Mamoon, Muhammad
2|System & Architectural Design|37|Team
2.1|Database Architecture|9|Muhammad
2.2|System & API Architecture|9|Mamoon, Muhammad
2.3|AI Pipeline & Machine Learning Planning|7|Mamoon
2.4|UI/UX Prototyping|14|Mamoon, Muhammad
2.5|Design Phase Complete|1|Dr. Tehseen, Mamoon, Muhammad
3|Software Requirement Specification (SRS)|34|Team
3.1|Functional Requirements Documentation|7|Mamoon, Muhammad
3.2|Non-Functional Requirements Documentation|3|Mamoon, Muhammad
3.3|Use Case Modeling|9|Mamoon, Muhammad
3.4|UML Diagramming|9|Mamoon, Muhammad
3.5|SRS Review, Finalization, and Approval|5|Dr. Tehseen, Mamoon, Muhammad
4|Software Design Specification (SDS)|24|Team
4.1|Architecture and Component Design Documentation|3|Mamoon, Muhammad
4.2|Entity-Relationship (ER) Modeling|12|Mamoon, Muhammad
4.3|Class and Object UML Diagrams|7|Mamoon, Muhammad
4.4|SDS Review, Finalization, and Approval|3|Dr. Tehseen, Mamoon, Muhammad
5|Development (Core Execution)|187|Team
5.1|Environment Setup|4|Muhammad
5.2|M01 - User Authentication & Identity Verification|9|Muhammad
5.2.1|Dual-Channel OTP System (Email + WhatsApp)|3|Muhammad
5.2.2|Role-Based Access Control|3|Muhammad
5.2.3|JWT Session Management|3|Muhammad
5.3|M02 - Market Intelligence Engine|12|Muhammad
5.3.1|Velocity & Days-on-Market Computation Logic|4|Muhammad
5.3.2|Demand Scoring Algorithm implementation|4|Muhammad
5.3.3|Gemini API integration for Plain-Text Trend|4|Muhammad
5.4|M03 - Targeted Scraping Engine|22|Muhammad
5.4.1|Scrapy Spiders (Zameen, OLX)|6|Muhammad
5.4.2|Playwright Spiders (Graana, Ilaan)|6|Muhammad
5.4.3|Proxy Rotation & Rate Limiting System|5|Muhammad
5.4.4|Data Cleaning & Cross-Platform Deduplication|5|Muhammad
5.5|M04 & M05 - Seller Outreach & Form Systems|20|Mamoon
5.5.1|AI Message Drafting & WhatsApp Dispatcher|7|Mamoon
5.5.2|Delivery Status Webhook implementation|6|Mamoon
5.5.3|Dynamic Category-Specific Form UI & Validation|7|Mamoon
5.6|M06 - AI Property Analyzer|10|Mamoon
5.6.1|Valuation & Feature Extraction Prompts|5|Mamoon
5.6.2|AI-Enhanced Description Generator|5|Mamoon
5.7|M07 - Buyer Outreach & Warm Lead Detection|28|Mamoon
5.7.1|Composite Lead Scoring Model (scikit-learn)|10|Mamoon
5.7.2|NLP Intent Classification (HOT/WARM/COLD)|10|Mamoon
5.7.3|Auto-follow-up Draft Generator|8|Mamoon
5.8|M08 - Listing Management System|20|Muhammad
5.8.1|Buyer Discovery UI & SSR Pages|10|Muhammad
5.8.2|Meilisearch Integration for filtering/indexing|10|Muhammad
5.9|M09 to M12 - Dashboards & Administration|35|Team
5.9.1|Seller Dashboard UI|8|Mamoon
5.9.2|Admin Control Panel|12|Muhammad
5.9.3|Campaign Dashboard|8|Muhammad
5.9.4|User Profiling and Settings|7|Mamoon
5.10|System Integration & End-to-End Linking|13|Mamoon, Muhammad
5.11|Core Development Complete|1|Dr. Tehseen
6|Testing|15|Team
6.1|Unit Testing|6|Mamoon, Muhammad
6.2|Integration Testing|6|Mamoon, Muhammad
6.3|Traceability Matrix & Test Results Documentation|3|Mamoon, Muhammad
7|Final Review & Delivery|53|Team
7.1|AI/Scoring Model Retraining & Calibration|5|Mamoon, Muhammad
7.2|Performance Optimization & Security Review|10|Mamoon, Muhammad
7.3|User Acceptance Testing (UAT)|8|Mamoon, Muhammad
7.4|Final Bug Fixing & Polishing|4|Mamoon, Muhammad
7.5|Final Report & Presentation Prep|18|Mamoon, Muhammad
7.6|Plagiarism Check & Final Submission|8|Dr. Tehseen, Mamoon, Muhammad"""
for line in wbs2_text.strip().split('\n'):
    parts = line.split('|')
    if len(parts) == 4:
        r = t2.add_row().cells
        r[0].text, r[1].text, r[2].text, r[3].text = parts[0], parts[1], parts[2], parts[3]

doc.add_page_break()

# User Stories V1
doc.add_heading('User Stories - Version 1 (Epic Summary)', level=1)
us1_text = """Epic 1: Access, Security & Administration
US-1.01: As a new user, I want to verify my identity using both an Email OTP and a WhatsApp OTP so that the platform guarantees all participants are real, verified individuals.
US-1.02: As a returning user, I want to securely log in and receive a role-based session (Admin, Seller, or Buyer) so that I only access the features relevant to my account.
US-1.03: As an Admin, I want to securely store and rotate my API keys from a dashboard so that I don't have to hardcode sensitive credentials.
US-1.04: As an Admin, I want to manage my proxy IP pool and scraper health in real-time.

Epic 2: Data Acquisition & Market Intelligence
US-2.01: As the System, I need to concurrently scrape Zameen, OLX, Graana, and Ilaan using rotating proxies so that I can bypass anti-bot measures.
US-2.02: As the System, I need to clean, normalize, and deduplicate cross-platform records.
US-2.03: As a Seller, I want to view an AI-generated market demand score for my city and category.

Epic 3: AI-Powered Listing Creation & Validation
US-3.01: As a Seller, I want to receive a secure, category-specific property form via WhatsApp.
US-3.02: As a Seller, I want the AI to analyze my form submission to generate a fair market valuation.
US-3.03: As a Seller, I want the AI to automatically draft a professional, 150+ word listing description.
US-3.04: As a Seller, I want the ability to review, edit, and approve the AI-generated description.

Epic 4: Automated Lead Generation & Outreach
US-4.01: As a Seller, I want the system to scrape competing platforms specifically for buyers seeking my property type.
US-4.02: As a Seller, I want the system to score and rank these buyer leads based on intent and budget alignment.
US-4.03: As a Seller, I want to review and approve AI-drafted WhatsApp outreach messages before they are dispatched.
US-4.04: As a Seller, I want the system to automatically classify WhatsApp replies via Webhook (HOT, WARM, COLD) and draft follow-up responses.

Epic 5: Buyer Marketplace & Discovery
US-5.01: As a Buyer, I want to browse a centralized hub of AI-enhanced, verified property listings.
US-5.02: As a Buyer, I want to filter listings using multiple criteria (category, city, price range).
US-5.03: As a Buyer, I want to save search preferences and receive email/WhatsApp alerts.
US-5.04: As a Buyer, I want to directly contact a seller through the platform.

Epic 6: Analytics & User Dashboards
US-6.01: As a Seller, I want a centralized dashboard showing my active scraping sessions and warm leads.
US-6.02: As a Seller, I want to track my closed deals and cumulative revenue on my dashboard.
US-6.03: As an Admin, I want to view a platform-wide analytics panel.
US-6.04: As a User, I want to manage my profile details, notification preferences, and request account deletion."""

for para in us1_text.split('\n'):
    if para.strip() != "":
        if para.startswith("Epic"):
            doc.add_heading(para.strip(), level=2)
        else:
            doc.add_paragraph(para.strip())

doc.add_page_break()

# User Stories V2
doc.add_heading('User Stories - Version 2 (Exhaustive FE Mapping)', level=1)
us2_text = """Epic 1: User Authentication & Security (Module 01)
US-1.01 (M01-FE1): As a new user, I want to submit a registration form (name, email, phone, role) so that my data is validated by Zod before hitting the database.
US-1.02 (M01-FE2): As the System, I need to generate a 6-digit email OTP, hash it with bcrypt, and dispatch it via SendGrid with a 10-minute expiry.
US-1.03 (M01-FE3): As the System, I need to generate a 6-digit phone OTP, hash it, and dispatch it via WhatsApp Cloud API.
US-1.04 (M01-FE4): As the System, I need to block account activation and outreach actions until both Email and Phone OTP hashes are successfully verified.
US-1.05 (M01-FE5): As a Security mechanism, I want to enforce rate-limiting on OTP resends using a database counter.
US-1.06 (M01-FE6): As a returning user, I want to log in with email/password and receive a signed JWT in an HttpOnly cookie.
US-1.07 (M01-FE7): As the Next.js Frontend, I need role-based middleware to automatically route Admin, Seller, and Buyer users to their portals.
US-1.08 (M01-FE8, FE9): As a user, I want a time-limited password reset flow delivered via email that ensures my new password hash does not match my old one.
US-1.09 (M01-FE10): As a user, I want to log out securely, which clears my JWT cookie and invalidates the session.

Epic 2: Targeted Scraping Engine (Module 03)
US-2.01 (M03-FE1): As a user, I want to submit a scraping request with category, city, and price range filters.
US-2.02 (M03-FE2): As the System, I must launch one parallel Celery task per platform and assign each a unique proxy IP from Redis.
US-2.03 (M03-FE3): As the Backend, I need Scrapy spiders configured to target and parse DOM elements specifically for Zameen and OLX.
US-2.04 (M03-FE4): As the Backend, I need Playwright spiders with randomized 3-7s delays and 13+ user-agent string rotations to scrape Graana and Ilaan.
US-2.05 (M03-FE5): As the Data Pipeline, I need to clean raw HTML, normalize PKR to integers, extract square footage, and reject null-price records.
US-2.06 (M03-FE6): As the Data Pipeline, I need to deduplicate records using platform/listing ID hashes, and apply fuzzy matching on title/price/locality.
US-2.07 (M03-FE7): As the System, I need to store the cleaned, deduplicated records in MongoDB, linked by a session_id.
US-2.08 (M03-FE8): As the System, I need to merge all 5 agents' outputs, rank them by exact category match and recency, and surface the top 10-15 records.
US-2.09 (M03-FE9): As the System, I need to log execution time, records fetched, rejected, and errors into the PostgreSQL audit log.

Epic 3: Market Intelligence Engine (Module 02)
US-3.01 (M02-FE1): As the Analytics Engine, I need to compute listing velocity by comparing new records in the last 7 days vs the prior 7 days.
US-3.02 (M02-FE2): As the Analytics Engine, I need to calculate the average days on market for active listings per category and city.
US-3.03 (M02-FE3): As the Analytics Engine, I need to compute the 14-day price movement percentage for each category/city.
US-3.04 (M02-FE4): As the System, I need to combine velocity, days on market, and price movement into a composite demand score using Admin weights.
US-3.05 (M02-FE5, FE6): As a Seller, I want the system to pass the demand scores to Gemini 2.0 Flash to generate a plain-language investment recommendation.
US-3.06 (M02-FE7): As the System, I need to run this entire analytics pipeline automatically via a Celery Beat schedule every 24 hours.

Epic 4: Seller Outreach Agent (Module 04)
US-4.01 (M04-FE1, FE2): As a Seller, I want the system to draft a WhatsApp outreach message via GPT-4o mini, and display it in a UI so I can manually review it.
US-4.02 (M04-FE3): As the System, upon user approval, I must format phone numbers to international standards and dispatch the message using a WABA template.
US-4.03 (M04-FE4): As the System, I need to listen to WhatsApp Webhooks in real-time to log delivery status (SENT, DELIVERED, READ, FAILED) into PostgreSQL.
US-4.04 (M04-FE5): As the System, when a seller replies to an outreach message, I must log the reply via Webhook and trigger the dispatch of the Seller Form link.
US-4.05 (M04-FE6): As the System, if a WhatsApp message fails, I need to retry once after 30 minutes, and mark it UNDELIVERED if it fails again.

Epic 5: Seller Form System (Module 05)
US-5.01 (M05-FE1): As the System, I must generate a unique, secure URL for the data collection form, tied explicitly to the seller's phone number.
US-5.02 (M05-FE2): As a Seller, I want to review an automated explanatory message before the system dispatches my form link to the property owner.
US-5.03 (M05-FE3): As the Form UI, I need to dynamically render different mandatory/optional fields based on property type (House, Shop, Plot, Plaza).
US-5.04 (M05-FE4): As the Backend, I must validate all form submissions strictly using Zod, returning field-level errors to the UI.
US-5.05 (M05-FE5, FE6): As the System, upon successful form submission, I must save the data to PostgreSQL, trigger the AI Analyzer, and notify the seller.

Epic 6: AI Property Analyzer (Module 06)
US-6.01 (M06-FE1, FE2): As the AI Engine, I need to compile the submitted form data and local MongoDB market comps, and prompt the LLM to generate a valuation, 3-5 selling features, and verify the category.
US-6.02 (M06-FE3): As the AI Engine, I need to execute a second LLM prompt to generate a 150+ word professional, ready-to-publish listing description.
US-6.03 (M06-FE4, FE5): As a Seller, I want to view the AI valuations, features, and description in a structured UI, with the ability to edit or Regenerate.
US-6.04 (M06-FE6): As the System, upon seller approval of the AI outputs, I must mark the property as ready for Buyer Outreach and Listing Publication.
US-6.05 (M06-FE7): As the System, I must handle Gemini/OpenAI API timeouts gracefully, logging the error and providing the user a manual Retry button.

Epic 7: Buyer Outreach & Warm Lead Detection (Module 07)
US-7.01 (M07-FE1): As a Seller, when I initiate a buyer campaign, I want the system to trigger the multi-agent scraper using my property's exact filters.
US-7.02 (M07-FE2): As the Scoring Engine, I need to pass scraped leads through Hugging Face NLP transformers to score buyer intent, budget alignment, category compatibility, and recency.
US-7.03 (M07-FE3): As the System, I want to filter out leads below an Admin-defined threshold and present the passing records to the Seller.
US-7.04 (M07-FE4, FE5): As a Seller, I want GPT-4o mini to draft campaign messages based on my property, let me edit them, and then dispatch them in bulk.
US-7.05 (M07-FE6): As the Webhook Listener, I need to analyze incoming buyer replies and classify their intent as HOT, WARM, or COLD.
US-7.06 (M07-FE7): As the System, I want to route HOT and WARM leads immediately to the Seller Dashboard with a real-time UI notification.
US-7.07 (M07-FE8): As the System, I want to auto-draft a contextual follow-up message to warm leads for the Seller to approve and send.

Epic 8: Listing Management System (Module 08)
US-8.01 (M08-FE1, FE2): As a Buyer, I want to view active properties on Server-Side Rendered (SSR) Next.js pages that include Schema.org markup.
US-8.02 (M08-FE3): As a Buyer, I want to filter the listings index page by property category, city, locality, price range, size range, and transaction type.
US-8.03 (M08-FE4): As a Buyer, I want to see a summary card and click through to a full detail page showing all AI-enhanced data and attributes.
US-8.04 (M08-FE5): As an authenticated Buyer, I want to save listings to my bookmarks and configure saved searches for email alerts.
US-8.05 (M08-FE6): As a Buyer, I want to fill out a contact request form on a listing, which logs a warm lead and pushes a notification to the Seller.
US-8.06 (M08-FE7): As an Admin, I want controls in my backend panel to manually publish, pause, or permanently delete any listing.

Epic 9: Seller Dashboard (Module 09)
US-9.01 (M09-FE1): As a Seller, I want a summary panel showing my active scraping sessions, top retrieved listings, scores, and outreach status.
US-9.02 (M09-FE2): As a Seller, I want a prioritized list of all warm leads (HOT first), showing the original reply content and follow-up status.
US-9.03 (M09-FE3): As a Seller, I want an interface to view, edit, or regenerate the AI analysis results for any of my confirmed properties.
US-9.04 (M09-FE4): As a Seller, I want to mark a deal as Closed, input the final sale price, and record my commission.
US-9.05 (M09-FE5): As a Seller, I want to view a 30-day visual activity chart tracking my campaign messages sent, warm leads received, and deals closed.

Epic 10: Admin Control Panel (Module 10)
US-10.01 (M10-FE1): As an Admin, I want a top-level analytics dashboard displaying total users, scrape sessions, leads, messages sent, warm leads, deals closed, revenue, and system uptime.
US-10.02 (M10-FE2): As an Admin, I want a scraper management UI showing last run time, 24hr record counts, success rates, and controls to trigger or pause any scraper.
US-10.03 (M10-FE3): As an Admin, I want a proxy pool UI to view active IP assignments, identify blocked IPs, and add/remove proxies dynamically.
US-10.04 (M10-FE4): As an Admin, I want a secure API credentials panel to rotate keys for Gemini, OpenAI, Hugging Face, WhatsApp Cloud, SendGrid, and Google Maps.
US-10.05 (M10-FE5): As an Admin, I want to adjust the composite lead score weights (intent, budget, category, recency) and minimum outreach thresholds from the UI.
US-10.06 (M10-FE6): As an Admin, I want a user management panel to search, filter, approve, suspend, or soft-delete user accounts.
US-10.07 (M10-FE7): As an Admin, I want access to a timestamped audit log of all system errors, scraper outcomes, and admin actions.

Epic 11: Campaign Dashboard (Module 11)
US-11.01 (M11-FE1): As a Seller, I want to view a list of all my buyer and seller outreach campaigns, showing their names, target properties, dates, and overall status.
US-11.02 (M11-FE2): As a Seller, I want to see real-time, per-message delivery metrics (sent, delivered, read, replied, failed, duplicate rejected) updated via callbacks.
US-11.03 (M11-FE3, FE4): As a Seller, I want a real-time feed of all incoming replies, classified by intent, with filters for date range, property, and delivery status.

Epic 12: User Profiling and Settings (Module 12)
US-12.01 (M12-FE1): As a user, I want to update my name, email, and phone number, with the system forcing a new OTP verification if contact details change.
US-12.02 (M12-FE2): As a user, I want to change my password securely by confirming my current password and verifying the new one doesn't match the old hash.
US-12.03 (M12-FE3): As a Buyer, I want an interface to configure my property preferences (categories, cities, max/min prices) for saved search alerts.
US-12.04 (M12-FE4): As a Seller, I want to toggle my notification preferences to control which events trigger in-app vs. WhatsApp alerts.
US-12.05 (M12-FE5): As a user, I want the ability to request full account deletion via a two-step confirmation flow that triggers system-wide data anonymization."""

for para in us2_text.split('\n'):
    if para.strip() != "":
        if para.startswith("Epic"):
            doc.add_heading(para.strip(), level=2)
        else:
            doc.add_paragraph(para.strip())

doc.add_page_break()

# Comparison Section
doc.add_heading('Comparison: Version 2 vs Version 1', level=1)

doc.add_heading('Why is Version 2 Better?', level=2)
doc.add_paragraph('Version 2 provides complete engineering traceability and execution granularity. It functions as an exhaustive "Engineering Execution Plan" directly tied to system architecture, whereas Version 1 was designed purely as an "Agile Epic Summary" for non-technical stakeholders to grasp business value.')

doc.add_heading('Why did Version 1 miss things?', level=2)
doc.add_paragraph('1. Audience Intent: Version 1 was framed as a high-level overview. Its goal was to explain the business value (the "What" and "Why") to stakeholders, grouping technical elements under broad umbrellas rather than exposing database and architecture chores.')
doc.add_paragraph('2. Abstraction of Chores: Version 1 intentionally omitted backend system chores—like proxy rotation, webhook retries, caching logic, and database deduplication—because end-users do not interact with them directly.')

doc.add_heading('Why they are explicitly included in Version 2:', level=2)
doc.add_paragraph('1. Principal Engineering Needs: As a Principal Software Engineer mapping work for sprints, "hidden" tasks (like configuring Celery Beats or rate-limiting OTPs) require dedicated time, story points, and testing. Version 2 captures these as "System Stories".')
doc.add_paragraph('2. 100% Traceability: Version 2 maps exactly 1:1 with every single Functional Element (FE) defined in the system architecture modules (M01 to M12) from the project scope document. Missing even one of these in the backlog means the feature won\'t get built, creating integration gaps.')
doc.add_paragraph('3. Sprint Readiness: Version 2 stories are granular enough to be immediately imported into Jira and assigned directly to developers (Mamoon or Muhammad). Version 1 stories were too large (Epics) and would need to be broken down heavily before coding could begin.')

doc.save('/home/soban-iftikhar/Projects/Java-SpringBoot-/LEADS_Project_Documentation.docx')
