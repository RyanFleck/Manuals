+++
date = 2022-03-02T19:00:14Z
image = ""
summary = "IBM's EAM Solution"
title = "Maximo"
toc = true

+++
# What is Maximo?

**IBM Maximo is an EAM (Enterprise Asset Management) solution.**

Heavy industry across the globe must deal with massive inventories with millions of parts, each with different stocking and holding costs, reordering processes, expiry dates, criticalities, and business requirements for counting and inventory management. Balancing all of these variables are systems like IBM Maximo, which aims to maximize the return of all enterprise assets through the optimization of cost, downtime, maintenance, repair material cost, and labor productivity.

**What Maximo is:**

* A tool to manage enterprise assets
* Planning and scheduling of asset maintenance and repair
* Organization of assets needed for maintenance and repair work
* Supply chain analytics to optimize stocking and reordering
* Generates (TPS?) reports to communicate the business status

**What Maximo is NOT:**

* A financial or accounting system - this must be managed in an external system which can optionally be connected to Maximo

**I have been extremely cautious to ensure no proprietary knowledge, client information, or insider info is included in this set of learning notes.** If you do notice any, please bring them to my attention immediately by contacting me with the information at [ryanfleck.ca/about](https://ryanfleck.ca/about).

This set of notes is primarily sourced from material on **Maximo 7.6+**

## Software Architecture

Maximo is a Java-based application that can run on a mainframe or in the cloud. Maximo 8 is significantly more complex than Maximo 7, which can run in a VM on a developer's computer as an EAR deployed on WebSphere along with an Oracle DB.

Here is a deployment diagram for Maximo 7 including Maximo Mobile:

![](/uploads/maximo-softarch.png)

Unfortunately (or fortunately,) the life of a Maximo consultant will _never stray near this Java application_. Customization for clients will almost always be feasible in the many, many customization layers above altering the Maximo source code.

Altering a client's Maximo will almost certainly **forfeit the support agreement** and **IBM can sue you for damages.** Don't do this.

## Applications

A Maximo Application is an access-restricted tool accessible through the Start Center that an end user will use to complete their work.

Within Maximo is a plethora of tools for use by a variety of roles. Commonly, Maximo end users (those working within the client organization,) will only see a handful of all the applications that are typically included with a Maximo installation. Many of the applications are designed only for use by developers and consultants or users with permission to customize the Maximo installation for the client's business needs.

A list of the **144** standard Maximo 7.6 applications can be found in a table [here](https://www.ibm.com/docs/en/mam/7.6.0.7?topic=levels-applications-their-data-storage) along with notes on where each application stores data.

Notably, developers will use the following applications to customize a client's Maximo installation and build new applications:

1. Application Designer
2. Automation Scripting
3. Database Configuration

![](/uploads/apps-1.png)

Details for the apps in the diagram above (1/5) can be found [here](https://maximosecrets.com/2017/02/07/maximo-applications-1-of-4/).

![](/uploads/apps-2.png)

Details for the apps in the diagram above (2/5) can be found [here](https://maximosecrets.com/2017/02/13/maximo-applications-2-of-4/).

![](/uploads/apps-3.png)

Details for the apps in the diagram above (3/5) can be found [here](https://maximosecrets.com/2017/02/21/maximo-applications-3-of-4/).

![](/uploads/apps-4.png)

Details for the apps in the diagram above (4/5) can be found [here](https://maximosecrets.com/2017/03/06/maximo-applications-4-of-4/).

![](/uploads/apps-5.png)

Details for the apps in the diagram above (5/5) can be found [here](https://maximosecrets.com/2018/11/20/maximo-applications-5-of-5/).

# Additional Resources

1. Maximo Secrets - [maximosecrets.com](https://maximosecrets.com/ "https://maximosecrets.com/")
2. Maximo 7.6 documentation - [ibm.com/docs/en/mam/7.6.0.7](https://www.ibm.com/docs/en/mam/7.6.0.7 "https://www.ibm.com/docs/en/mam/7.6.0.7")