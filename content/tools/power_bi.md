---
toc: true
date: 2023-08-10T18:31:00-06:00
image: "/content-cover-images/coffee-phone.jpg"
summary: "Microsoft's 'Business Intelligence' insight creation and sharing tool."
title: "Power BI"
---

# A Brief Introduction

Power BI is a collaborative cloud Excel that also allows the querying of data from databases and sharing of 'dashboards' which enables up-to-date visualisations of the data manipulated by the user.

# The Interface

![A new Power BI project](/images/powerbi/powerbi.png)

The three icons on the left are:

1. **Report** - Graphs and tools to share later.
2. **Data** - Browse tables you have connected to.
3. **Relationships** - Connects different tables and datasources with common fields. The action zone.

The far right of the window shows the tables you have loaded from excel files or databases.

Above, the ribbon contains dynamic tools based on the view selected on the left.

The report view allows you to place floating widgets that can align with other elements on the page. Formatting tools appear below the elements.

![A new text box](/images/powerbi/textbox.png)

In the **Report** view there is a **Mobile Layout** option in the View tab that allows you to customize the view of the report when viewed on a phone.

In the Modeling tab you can provide a **'What If?'** interface which gives the frontend user a parameter they can manipulate.

# Importing from Excel

There is an "Excel Workbook" button that allows you to load Excel files into a PowerBI report. Notably, tables that are formatted as tables in the Excel file appear as little blue table icons in the import view, and otherwise everything else appears as a sheet.

_Import the table itself when possible._

# Simple Dashboard

Create new visuals by opening the report view and selecting column names in the data view. Selecting different columns first will bring up different kinds of visual by default.

![A simple report](/images/powerbi/simple-report-1.png)

Here, the charts were created by selecting profit then region and profit then product. This automatically creates bar charts.

![A simple after 'scoping in' to the South region](/images/powerbi/simple-report-2.png)

The formatting options gives access to data labels, colors, axis settings, etc.

# Resources

1. [O'Reilly 'Power BI Masterclass' by Daniel Weikert](https://learning.oreilly.com/videos/power-bi-masterclass/9781789533095/)
