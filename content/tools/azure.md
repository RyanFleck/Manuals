+++
date = 2023-01-03T21:55:30Z
image = ""
summary = "Microsoft's cloud services platform"
title = "Azure"
toc = true

+++
# Learning Roadmap

As recommended to me:

![](/uploads/azure-roadmap.png)

Take these certifications in order:

* AZ-900
* AZ-104
* AZ-303

# AZ-900

Notes on [udemy.com/course/az900-azure](https://www.udemy.com/course/az900-azure/), taken January 2023.

Learning goals:

* Describe cloud concepts (25–30%)
* Describe Azure architecture and services (35–40%)
* Describe Azure management and governance (30–35%)

Links and Resources:

* Exam requirements: [learn.microsoft.com/en-us/certifications/exams/az-900](https://learn.microsoft.com/en-us/certifications/exams/az-900 "learn.microsoft.com/en-us/certifications/exams/az-900")
* Study guide: [AZ-900 study guide](https://query.prod.cms.rt.microsoft.com/cms/api/am/binary/RE3VwUY)

## Describe Cloud Computing

**Learning goals:**

* Define cloud computing
* Describe the shared responsibility model
* Define cloud models, including public, private, and hybrid
* Identify appropriate use cases for each cloud model
* Describe the consumption-based model
* Compare cloud pricing models

**Cloud computing** is the ability to rent computing resources on demand, and only pay for what you use. Microsoft has already made the billion-dollar investment in hardware, networking, etc.

The **Shared Responsibility Model** relates responsibilities in the cloud environment to a traditional on-premises service deployment, where you are responsible for everything from building and network security to networking and firewalls to the operating systems and authentication, devices, and data. These responsibilities fall away in different ways if you use the cloud.

By using a **Cloud VM** (IaaS\[^iaas\]), you'll still need to worry about the OS, networking, and the application, but the physical computer and networking is handled.

[^iaas]: Infrastructure as a Service

By using an **App Service** (PaaS[^paas]), you can now allow the cloud service to handle operating system patches and updates.

[^paas]: Platform as a Service

At a very high level there is **Software as a Service** (SaaS[^saas]) which prohibits the control of the network and application, just giving you access to a cloud software from a vendor.

[^saas]: Software as a Service

With these resources, you lose some control and responsibility, and are paying for a company (Microsoft Azure or others,) to manage those responsibilities for you. The hope is that they manage it competently.

![](/uploads/screenshot-2023-01-03-at-4-02-01-pm.png)

[learn.microsoft.com/en-us/azure/security/fundamentals/shared-responsibility](https://learn.microsoft.com/en-us/azure/security/fundamentals/shared-responsibility)

**Cloud Types:**

1. **Public Cloud** -- Anybody can sign up with a credit card and use services right away. Azure owns the hardware and the network.
1. **Private Cloud** -- Only avaialabe to select users in a business, can run on a businesses' private hardware, though looks and acts almost like a public cloud to end users.
1. **Hybrid Cloud** -- Combination of public and private, usually a network interconnection between on-prem and public or private cloud.

On-prem, cost can be predicted by adding hardware, power, internet, licensing, and employee costs. In the cloud, cost is based on **consumption**, usually by a number of metrics. A database could be priced by the CPU speed and RAM per minute, the consumed storage, an optional dedicated gateway, and number/size of backups.

This algorithmic pricing falls into a few different categories:

1. **Free services** usually exist below a certain usage quota.
2. **Time** can be used to price many resources, ex. reserve compute
3. **Per GB** is used to price storage and network egress[^egress]
4. **Per Operation** for databases and messaging, ex. reads/writes
5. **Per Execution** for serverless functions

[^egress]: Data flowing out of a network

Pricing will also vary by **region** and **cloud**. Providers try to price their services so it will save money for most of their client workloads. Ideally the capital expenditure and ongoing operating expenditures can be slowly reduced as services are moved to Azure, and a client will be left with an overall lower operating cost after all services are moved.

**CapEX** -- Capital Expenditure, like hardware

**OpEX** -- Ongoing Expenditure, like power and cooling

![](/uploads/cloud-on-premises-comparison.png)

[A Business Case for Cloud Migration](https://learn.microsoft.com/en-us/azure/cloud-adoption-framework/strategy/cloud-migration-business-case)

The cost savings comes from Microsoft's ability to run servers where power and cooling are cheap, so they can make a profit while still providing the computing service at a far lower TCO.

**TCO** -- Total Cost of Ownership



## Benefits of Cloud Computing

**Learning goals:**

* Describe the benefits of high availability and scalability in the cloud
* Describe the benefits of reliability and predictability in the cloud
* Describe the benefits of security and governance in the cloud
* Describe the benefits of manageability in the cloud

## Cloud Service Types

**Learning goals:**

* Describe infrastructure as a service (IaaS)
* Describe platform as a service (PaaS)
* Describe software as a service (SaaS)
* Identify appropriate use cases for each cloud service (IaaS, PaaS, SaaS)

## Core Architectural Components of Azure

**Learning goals:**

* Describe Azure regions, region pairs, and sovereign regions
* Describe availability zones
* Describe Azure datacenters
* Describe Azure resources and resource groups
* Describe subscriptions
* Describe management groups
* Describe the hierarchy of resource groups, subscriptions, and management groups

## Azure Compute and Networking Services

**Learning goals:**

* Compare compute types, including container instances, virtual machines (VMs), and functions
* Describe VM options, including Azure Virtual Machines, Azure Virtual Machine Scale Sets, availability sets, and Azure Virtual Desktop
* Describe resources required for virtual machines
* Describe application hosting options, including the Web Apps feature of Azure App Service, containers, and virtual machines
* Describe virtual networking, including the purpose of Azure Virtual Networks, Azure virtual subnets, peering, Azure DNS, Azure VPN Gateway, and Azure ExpressRoute
* Define public and private endpoints

## Azure Storage Services

**Learning goals:**

* Compare Azure storage services
* Describe storage tiers
* Describe redundancy options
* Describe storage account options and storage types
* Identify options for moving files, including AzCopy, Azure Storage Explorer, and Azure File Sync
* Describe migration options, including Azure Migrate and Azure Data Box

## Identity, Access, and Security

**Learning goals:**

* Describe directory services in Azure, including Microsoft Azure Active Directory (Azure AD), part of Microsoft Entra and Azure Active Directory Domain Services (Azure AD DS)
* Describe authentication methods in Azure, including single sign-on (SSO), multifactor authentication, and passwordless
* Describe external identities and guest access in Azure
* Describe Conditional Access in Microsoft Azure Active Directory (Azure AD), part of Microsoft Entra
* Describe Azure role-based access control (RBAC)
* Describe the concept of Zero Trust
* Describe the purpose of the defense in depth model
* Describe the purpose of Microsoft Defender for Cloud

## Azure Cost Management

**Learning goals:**

* Describe factors that can affect costs in Azure
* Compare the Pricing calculator and the Total Cost of Ownership (TCO) calculator
* Describe the Azure Cost Management and Billing tool
* Describe the purpose of tags

## Azure Governanace and Compliance

**Learning goals:**

* Describe the purpose of Azure Blueprints
* Describe the purpose of Azure Policy
* Describe the purpose of resource locks
* Describe the purpose of the Service Trust Portal

## Tools for Managing and Deploying Azure Resources

**Learning goals:**

* Describe the Azure portal
* Describe Azure Cloud Shell, including Azure CLI and Azure PowerShell
* Describe the purpose of Azure Arc
* Describe Azure Resource Manager and Azure Resource Manager templates (ARM templates)

## Monitoring Tools

**Learning goals:**

* Describe the purpose of Azure Advisor
* Describe Azure Service Health
* Describe Azure Monitor, including Log Analytics, Azure Monitor alerts, and Application Insights

# Footnotes