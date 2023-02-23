+++
date = 2023-01-03T21:55:30Z
image = ""
summary = "Microsoft's cloud services platform"
title = "Azure"
toc = true

+++

# Learning Roadmap

As a growing Software Architect I was recommended to pursue:

![Cloud journey roadmap provided by an IBM colleague](/uploads/azure-roadmap.png)

**Certification Checklist:**

- AZ-900 ✔
- AZ-104
- AZ-303

# AZ-900

The [AZ-900: Microsoft Azure Fundamentals](https://learn.microsoft.com/en-us/certifications/exams/az-900/) exam is an entry-level credential to prove knowledge of the fundamentals of Microsoft's Azure cloud computing platform.

> Azure Fundamentals exam is an opportunity to prove knowledge of cloud concepts, Azure services, Azure workloads, security and privacy in Azure, as well as Azure pricing and support. Candidates should be familiar with the general technology concepts, including concepts of networking, storage, compute, application support, and application development.

I began studying for this exam by taking an [AZ-900 prep course on Udemy](https://www.udemy.com/course/az900-azure/) in January 2023 and passed the in-person exam a month later.

![I received this credential on February 22nd, 2023. [Credly badge](https://www.credly.com/badges/bf41835d-fa5a-44df-a1f5-521e3c211235).](/images/azure/azure-fundamentals-certified.png)

**Learning Goals:**

- Describe cloud concepts (25–30%)
- Describe Azure architecture and services (35–40%)
- Describe Azure management and governance (30–35%)

**Links and Resources:**

- Exam requirements: [learn.microsoft.com/en-us/certifications/exams/az-900](https://learn.microsoft.com/en-us/certifications/exams/az-900 "learn.microsoft.com/en-us/certifications/exams/az-900")
- Study guide: [AZ-900 study guide](https://query.prod.cms.rt.microsoft.com/cms/api/am/binary/RE3VwUY)
- Practice questions: [ExamTopics AZ-900 Q&A](https://www.examtopics.com/exams/microsoft/az-900/view/1/)

An IBM colleague warned me that **just taking the Udemy course is insufficient to pass** the AZ-900 exam. Consider finding lots of additional practice questions, and focus on the specific services used to build solutions to client problems.

## Describe Cloud Computing

**Learning goals:**

- Define cloud computing
- Describe the shared responsibility model
- Define cloud models, including public, private, and hybrid
- Identify appropriate use cases for each cloud model
- Describe the consumption-based model
- Compare cloud pricing models

**Cloud computing** is the ability to rent computing resources on demand, and only pay for what you use. Microsoft has already made the billion-dollar investment in hardware, networking, etc.

The **Shared Responsibility Model** relates responsibilities in the cloud environment to a traditional on-premises service deployment, where you are responsible for everything from building and network security to networking and firewalls to the operating systems and authentication, devices, and data. These responsibilities fall away in different ways if you use the cloud.

By using a **Cloud VM** (IaaS[^iaas]), you'll still need to worry about the OS, networking, and the application, but the physical computer and networking is handled.

[^iaas]: Acronym: **IaaS: Infrastructure as a Service:** The cloud provides networked hardware but does not manage the software running on the systems.

By using an **App Service** (PaaS[^paas]), you can now allow the cloud service to handle operating system patches and updates.

[^paas]: Acronym: **PaaS: Platform as a Service:** Provides a basis for common services or easy deployment of code while the cloud manages the underlying OS and maintaining/monitoring the running software, handles upgrades and automatic deployments, etc.

At a very high level there is **Software as a Service** (SaaS[^saas]) which prohibits the control of the network and application, just giving you access to a cloud software from a vendor.

[^saas]: Acronym: **SaaS: Software as a Service:** A managed application running in the cloud with no client control of the resources consumed by the application, deployment, etc.

With these resources, you lose some control and responsibility, and are paying for a company (Microsoft Azure or others,) to manage those responsibilities for you. The hope is that they manage it competently.

![A diagram with [shared responsibility](https://learn.microsoft.com/en-us/azure/security/fundamentals/shared-responsibility) by cloud model.](/uploads/screenshot-2023-01-03-at-4-02-01-pm.png)

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

![A [Business Case](https://learn.microsoft.com/en-us/azure/cloud-adoption-framework/strategy/cloud-migration-business-case) for Cloud Migration.](/uploads/cloud-on-premises-comparison.png)

The cost savings comes from Microsoft's ability to run servers where power and cooling are cheap, so they can make a profit while still providing the computing service at a far lower TCO.

**TCO** -- Total Cost of Ownership

**Autoscaling** can be used in the cloud to ensure your resouces are not **overprovisioned** which is the typical scenario when buying physical hardware to avoid overloaded hardware.

## Benefits of Cloud Computing

**Learning goals:**

- Describe the benefits of high availability and scalability in the cloud
- Describe the benefits of reliability and predictability in the cloud
- Describe the benefits of security and governance in the cloud
- Describe the benefits of manageability in the cloud

### High Availability

Cloud services provide guarantees of reliability that use high availability as a metric. With 44640 minutes in a 31 day month, the following "number of nines" define the contractually allowed downtime:

1. 99.99% available: 4.464 minutes of downtime aka "four nines"
1. 99.999% available: 0.4464 minutes (26.7 seconds) of downtime
1. 99.9999% available: 0.04464 minutes (2.67 seconds) of downtime

...etc

No amount of money can achieve 100% availability.

**Scalability** -- The ability of a system to handle growth of users or work; scaling is the ability to add capacity to an application.

**Elasticity** -- The ability of a system to automatically grow and shrink based on application demand. Capacity is kept above user demand.

### Reliability and Predictability

**SLA** -- Service Level Agreement: A guarantee of availability, reliability, etc backed with financial compensation (refunds) for failures.

Azure has published timelines and procedures for rollouts of new hardware and software. Tools are provided to deploy applications across multiple regions to address this scheduled downtimes.

Azure provides **Chaos Studio** to simulate various failures to see how your application responds, adapts, or dies.

**Global Availability** can be achieved by deploying your application across the many worldwide Azure datacenters, and this is something that is difficult to achieve for a corporation of any scale.

### Security, Governance, Monitoring

- Security is a huge job and offloading it to the cloud reduces costs
- Azure has **AI/ML connection rejection** tech
- Azure has basic **DDOS protection** for free
- Azure provides data governance assistance to meet business and government/regulatory requirements around data. **Azure Blueprints** and **Azure Policy** can be used to automatically take actions, enforce rules, and create reports.
- Azure provides **monitoring of raised errors** and automation to act on them without human intervention

## Cloud Service Types

**Learning goals:**

- Describe infrastructure as a service (IaaS[^iaas])
- Describe platform as a service (PaaS[^paas])
- Describe software as a service (SaaS[^saas])
- Identify appropriate use cases for each cloud service (IaaS, PaaS, SaaS)

![A diagram showing [cloud service types](https://learn.microsoft.com/en-us/azure/azure-sql/azure-sql-iaas-vs-paas-what-is-overview) that can run on Azure.](/uploads/sqliaas_sql_server_cloud_continuum.png)

**IaaS** -- Infrastructure as a Service offers compute, networking, and storage resources on demand, where you take full responsiblity for how your application is deployed and for most of the configuration of the underlying resources.

**PaaS** -- Platform as a Service is a complete deployment environment. It doesn't give access to the VM typically, but will provide a wealth of convenience tools to support the web app development lifecycle. Auto deployments from repositories, etc. _You can upload code here and it will run._ Serverless functions fall into this category but you have even less control of where things run -- you don't need to worry about scaling or the correct performance plan.

**SaaS** -- Zero control over what's going on under the hood, you just get access to the application. Like the Azure Portal, Slack, Office 365.

## Core Architectural Components of Azure

**Learning goals:**

- Describe Azure regions, region pairs, and sovereign regions
- Describe availability zones
- Describe Azure datacenters
- Describe Azure resources and resource groups
- Describe subscriptions
- Describe management groups
- Describe the hierarchy of resource groups, subscriptions, and management groups

```
AZURE ARCHITECTURAL HIERARCHY 2022

Management Groups
 |__ Subscriptions
      |__ Resource Groups
           |__ Resources
```

### Regions, Region Pairs, and Sovereign Regions

**Regions** are Azure datacenters that exist in or near certain locations in the globe.

**Region Pairs** are designed to have fast connections between them. They are the ideal failover location for running applications. A region pair will never have both _Regions_ down for maintenance.

For example:

1. Canada Central <-> Canada East
1. US West <-> US East
1. North Europe <-> West Europe

**Sovereign Regions** are unavailable to most Azure subscribers, like _China_ or _Azure Government (US)_.

### Availability Zones & Datacenters

**Availability Zones** futher subdivide _Regions_. They are separate datacenter buildings within a _Region_. They enable another layer of failover if one datacenter in a region fails and your application is running on multiple _AZs_.

Datacenters must be withink 50km of one another to be grouped in a single region.

### Azure Resources and Resource Groups

**Resource Groups** are logical groupings of Azure resources typically based on shared function.

**Resources can only be part of one group, and must be part of a group.**

### Subscriptions & Management Groups

A **Subscription** is a billing unit. You'd want to have a Subscription for each client that you manage. All resources that are consumed by a subscription will be billed by the owner. Subscriptions can also be used to break up billing into dev/production or by department.

Subscriptions can be organized into nested **Management Groups** to enforce policies and access.

## Azure Compute and Networking Services

**Learning goals:**

- Compare compute types, including container instances, virtual machines (VMs), and functions
- Describe VM options, including Azure Virtual Machines, Azure Virtual Machine Scale Sets (VMSS), availability sets, and Azure Virtual Desktop
- Describe resources required for virtual machines
- Describe application hosting options, including the Web Apps feature of Azure App Service, containers, and virtual machines
- Describe virtual networking, including the purpose of Azure Virtual Networks, Azure virtual subnets, peering, Azure DNS, Azure VPN Gateway, and Azure ExpressRoute
- Define public and private endpoints

### Compute Types

**Amazon EC2 (Elastic Compute Cloud) is akin to Azure VMs.** With VMs, you can pick from a menu of different CPU types, paired with different amounts of memory and storage. [menu](https://azure.microsoft.com/en-ca/pricing/details/virtual-machines/windows/)

**VM Scale Sets** are a functionality provided for free, though you do need to pay for the consumed vm-hour-storage-memory units. Enables 2+ machines to run the same code and autoscale with more machines (up to 100 by default or 1000 configured.)

**App Services** (PaaS) runs an application with no knowledge of the underlying hardware apart from basic specs, like Heroku.

**Azure Container Instance (ACI)** can run a single container or a group of containers with Docker Compose.

**Azure Kubernetes Service (AKS)** can run a cluster of containers.

**Azure Virtual Desktop (AVD)** provides a virtual desktop for work purposes.

### Networking Services

**Virtual Networks** or **Virtual Private Clouds (VPC) on AWS** emulate a physical network and allow you to work remotely or combine physical networks.
Creating interconnected virtual networks or **subnets** with different security settings in Azure is just a software configuration called _peering_ as it is all networked physically.

**Address Spaces** define the number of available IP addresses in your VNet, 10.0.0.0/16 indicates a 16 bit subnet mask, giving you the last 16 bits in the address for your IPs (~65k with a 16 bit subnet mask.)

**VPN Gateways** allow you to connect networks together, between on-prem and Azure or your local machine to your business network.

**VNet Peering** enables the interconnection of vnets.
One-way and two-way traffic can be configured between peered subnets. Global peering is possible but costs money for bandwidth: egress from zone A, and ingress to zone B.

**Private Endpoints** allow you to make a resource accessible only at a [specific IP on a virtual network](https://learn.microsoft.com/en-us/azure/private-link/private-endpoint-overview).

**ExpressRoute** is a high speed PHYSICAL CABLE private connection to Azure.

**Azure DNS** allows you to take control of the DNS records for your domain.

## Azure Storage Services

**Learning goals:**

- Compare Azure storage services
- Describe storage tiers
- Describe redundancy options
- Describe storage account options and storage types
- Identify options for moving files, including AzCopy, Azure Storage Explorer, and Azure File Sync
- Describe migration options, including Azure Migrate and Azure Data Box

Blob, disk, file storage.

In an **Azure Storage** account, the most common storage type is general purpose v2 (**GPV2**) which can
hold blobs, tables, queues, and files. It's the cheapest as well at roughly 2 cents per GB.
This is equivalent to **AWS S3**.

**BLOB = Binary Large OBject**

**Blob or Unmanaged Storage** like gpv2 allows you to store objects and be charged by size and egress. Blob storage is organized into _containers_ and the access tier, block size, [endpoints,](https://learn.microsoft.com/en-us/azure/storage/common/storage-account-overview#standard-endpoints)
etc can be set on a per-container basis in a storage account. Temporary permissions can be generated for a blob by creating an [SAS key](https://learn.microsoft.com/en-us/azure/storage/blobs/sas-service-create?tabs=dotnet) that allows you to read or write, etc.

**Disk Storage** allows you to take control of a full pre-allocated disk, and you pay for the disk size and speed regardless of usage.

**Access tiers** - hot, cool, archive -- the cool tier is half the price, but is slower and costs more to access. Archive tier is ~10% of the cost of hot storage, but may take hours to access.

Performance tiers - premium, standard

Location - keep close to your application instances

**Redundancy** - multiple replicated copies of files in different regions. Options include:

1. **LRS** -- Locally-redundant storage, multiple disks in one datacenter, the default.
1. **GRS** -- Geo-redundant storage, disks in different regions, good for backups.
1. **ZRS** -- Zone-redundant storage, disks in different zones, good for high availability.
1. **GZRS** -- Geo-zone-redundant storage, good for critical data.

Failover - automatically using a storage backup

**Data Lake Storage Gen 2** enables hierarchical namespaces and access to parts of a ludicrously large virtual filesystem.

**To move files, there are four options available:**

1. Blob container view, for development.
2. **Azure Storage Explorer/Browser** which allows you to see all files in a storage account and manipulate them.
3. **AzCopy** allows you to copy data between storage accounts on the Azure network to prevent egress and ingress fees. It can run within the Azure cloud shell, or locally to move things to and from the cloud. With a blob SAS and container SAS, you can copy a blob to a new container. You can even copy from other clouds or anything with a URL.
4. **Azure File Sync** is uses to synchronize on-premise disks with **cloud file shares**. Fileshares are typically connected to via the [SMB](https://learn.microsoft.com/en-us/windows/win32/fileio/microsoft-smb-protocol-and-cifs-protocol-overview) protocol, [NTLM v2](https://learn.microsoft.com/en-us/windows-server/security/kerberos/ntlm-overview) authentication, and [AES-128-GCM](https://www.aes-gcm.com/) encryption. To set this up with a storage account, add a storage sync service, and install the file sync agent on the target.

```ps1
# PowerShell (.ps1) AZCopy Example

azcopy -?  # see if it's installed

azcopy copy '<url to source>' '<url to dest>'
```

**Migration Tools and Strategies:**

1. **Azure Migrate** is a guided experience for IT to migrate their resources to the cloud. It includes tools to _map your current environment_ so you'll know what you need to provision in Azure. The tool will make recommendations and raise flags if current tech is unable to be moved in a conventional/easy way.
2. **Azure Data Box** is for scenarios where massive volumes (Terabytes to Petabytes) of data must be moved to the cloud. Data boxes range in size from a single SSD (8TB) to a box (100TB) to a "Data Box Heavy" on wheels (1PB). The data will be shipped encrypted and uploaded to your account when it arrives.

![Options for migrating data to Azure.](/uploads/data-box.png)

## Identity, Access, and Security

<!-- LEARNING GOALS -->

**Learning goals:**

- Describe directory services in Azure, including Microsoft Azure Active Directory (Azure AD), part of Microsoft Entra and Azure Active Directory Domain Services (Azure AD DS)
- Describe authentication methods in Azure, including single sign-on (SSO), multifactor authentication, and passwordless
- Describe external identities and guest access in Azure
- Describe Conditional Access in Microsoft Azure Active Directory (Azure AD), part of Microsoft Entra
- Describe Azure role-based access control (RBAC)
- Describe the concept of Zero Trust
- Describe the purpose of the defense in depth model
- Describe the purpose of Microsoft Defender for Cloud

<!-- NOTES AND CONTENT -->

Generally, **identity** is a digital representation of an entity that requires access to a system. This could be a person, device, or robot/application. Digital identity requires proof such as a key, password, or certificate.

**Authentication:** who are you?

**Authorization:** what are you allowed to do?

**Azure AD** is a security protocol used on Azure. It is **identity as a service** (idaas? lol.)
Much like OAuth, the web server is passed a signed/trusted token it can use to identify the user.

![Using Azure AD means skipping writing a complex security system, as AAD includes [MFA](https://learn.microsoft.com/en-us/azure/active-directory/authentication/overview-authentication)
and plenty of other security measures built in.](/images/azure/authenticationflow.png)

Azure AD offers a centralized, consistent, secure approach to using your org's applications, and even many applications outside your organization or SaaS offerings.

AAD has the ability to configure **conditional access** which detects _unusual logins_ and can block access or ask for additional information. For example, is the user on the company network? Have they not logged in for years? AAD calls these _signals_.

**MFA: Multi-Factor Authentication** -- Requires _two or more_ pieces of evidence that the user is not an impostor. This can be something you **know** (password), something you **have** (phone), or something you **are** (biometric artifact).

**Passwordless authentication** attempts to reduce the inconvenience of MFA while retaining the security benefits. Essentially MFA without passwords as an auth option. Can be simple games while carefully checking _signals_ like the device.

Azure **RBAC** (role based access control) allows administrators to enable granular access to all the Azure services for a variety of roles. Readonly to storage for business roles, control over virtual machines for developers, the ability to create and destroy VMs and storage for developer admins, etc. It's easy to create custom permissions and roles. It is rare to manage permissions on an individual level, it is far more common to use roles.

**Common Azure Permissions:**

1. **Reader** -- Can read
1. **Contributor** -- Can read and write
1. **Owner** -- Can assign permissions to other users

**Zero Trust** means providing many security thresholds within a service or between applications, with everything locked by default, only enabling access to exactly what is needed to complete work. The principles of zero trust are:

1. Verify explicitly
1. Use least privileged access
1. Assume [your network has been] breached

**JIT:** Just in Time -- only grant permissions when needed

**JEA:** Just Enough Access -- don't over-provision access

![A map of Microsoft's [zero trust](https://www.microsoft.com/en-us/security/business/zero-trust) policy security model.](/images/azure/security-policy.png)

1. **Applications** should have appropriate user powers and monitor users.
1. **Data** should be encrypted and access should be restricted
1. **Infrastructure** should be monitored to detect attacks and unusual usage

Provide ample security within the network: encryption, segmentation, threat detection, etc.

The **Defense in Depth** principle means applying security best practices at every level of an organization:

1. Physical -- locks and room access
1. Identity -- Azure AD
1. Network -- ddos, firewalls, subnets, deny by default
1. Compute -- limit RDP use, access, keep servers up to date
1. Apps -- APIs are well written and secure
1. Data -- Tightly scoped vnet access

Azure provides many tools for each category.

![Sample _defense in depth_ slide showing security layers.](/images/azure/defense-in-depth.jpg)

**Microsoft Defender for Cloud** provides security, posture management, and threat detection. By paying per resource per month (~$15USD per server) Microsoft provides an in-depth security analysis and monitoring of the resource.

## Azure Cost Management

<!-- LEARNING GOALS -->

**Learning goals:**

- Describe factors that can affect costs in Azure
- Compare the Pricing calculator and the Total Cost of Ownership (TCO) calculator
- Describe the Azure Cost Management and Billing tool
- Describe the purpose of tags

<!-- NOTES AND CONTENT -->

Billing is calculated from a broad variety of factors depending on the service. Many services have a free tier or are free below a certain limit, like virtual networks, load balancing, basic AAD, and free-tier web apps. Using pay-by-consumption or serverless models can save organizations a lot of money -- one million executions of an Azure Function will cost ~$0.20 USD. Per second billing is used for resources like VMs and disks.

Pricing can be made more stable with a 1 -> 3 year commitment in reserved VM instances. Long-term contracts can be made to reduce storage, VM, networking costs.

**Azure is priced to increase cloud utilization.**

Ingress (inbound data) is almost always **free** for obvious reasons.

1PB of data would cost **~$52,000 USD** to remove from Azure.

The Azure [Pricing Calculator](https://azure.microsoft.com/en-ca/pricing/calculator/)
allows consultants to make an educated guess about the costs of a service.
As Azure's pricing changes, the cost of provisioned services will change, so the pricing calculator must be used with this in mind.

![The 2022 **Azure Pricing Calculator** homepage.](/images/azure/pricing-calculator-1.png)

![The calculator provides common scenarios.](/images/azure/pricing-calculator-2.png)

**TCO: Total Cost of Ownership** can be estimated with the [Azure TCO Calculator](https://azure.microsoft.com/en-ca/pricing/tco/calculator/) and is oriented towards comparing current on-prem costs with a potential Azure re-deployment. It attempts to factor in power, networking costs, hardware costs, software licenses, and IT personnel costs to determine if the client will attain a _hybrid benefit_ from moving some or all of their workload to Azure.

**Resource Tags** can be used to organize which department the bills for a certain resource are sent. Tags can be used for many other things, but they are particularly useful for billing as dashboards can show cost by tag.

_\*BRRRING!\* \*BRRRING!\* \*CLICK!\* \*SHFHFHFUF-FLE-SHUFFLFL!\*_

**HELLO SIR** YOU HAVE REACHED **THE BILLING DEPARTMENT SIR** WHAT IS YOUR BILLING CODE SIR!?
**SIR!? ARE YOU THERE SIR!?!?** HELLO??? SIR!?

_\*CLICK!\*_

### Dashboards for Cost Management & Billing

Running costs can be viewed and analyzed with free Azure tools. Budgets can be specified, payments tracked, and recommendations given by the system. The dashboard can provide spending estimates and configurable alerts.

![An [example dashboard](https://azure.microsoft.com/en-us/products/cost-management/#overview) showing spending analytics.](/images/azure/azure-cost-mgmt.png)

Reports can be scheduled showing resource usage.

## Azure Governanace and Compliance

<!-- LEARNING GOALS -->

**Learning goals:**

- Describe the purpose of Azure Blueprints
- Describe the purpose of Azure Policy
- Describe the purpose of resource locks
- Describe the purpose of the Service Trust Portal

A company may have certain IT rules that they want to implement. Azure provides a variety of tools to enforce these policies programmatically. For instance: _Ensure all servers have at least one daily backup._

This rule can either be enforced socially, with an email to IT, or programmatically in Azure, with tools like those listed in the learning goals above which will now be explored.

**Azure Blueprint** provides a way to standardize the creation and management of subscriptions. It can create and enforce security rules, resource groups, and policies across a set of subscriptions that can be per client or just per department.

**Azure Policy** provides a way to programmatically define and enforce these rules. For example, you can mandate:

- A mininum SQL server version
- Limit which virtual machine SKUs can be used
- Define required tags and their default values

You can also _write your own policies_ to help prevent unsafe practices and limit costs.

**Resource Locks:** You can mark a resouce as read only to ensure other users cannot modify the state of the VM, delete it, or modify its properties. You can ensure only a limited subset of people can apply and remove locks.

The **Service Trust Portal** holds all the [documents](https://servicetrust.microsoft.com) related to Azure's compliance towards regulations and standards. It even contains **blueprints** for certain applications and industries, like healthcare or US Government.

<!-- NOTES AND CONTENT -->

## Tools for Managing and Deploying Azure Resources

<!-- LEARNING GOALS -->

**Learning goals:**

- Describe the Azure portal
- Describe Azure Cloud Shell, including Azure CLI and Azure PowerShell
- Describe the purpose of Azure Arc
- Describe Azure Resource Manager and Azure Resource Manager templates (ARM templates)

<!-- NOTES AND CONTENT -->

**Azure Portal:** Available at portal.azure.com, Microsoft provides a web GUI for creating and managing all Azure resources.

**Azure Cloud Shell, CLI, Powershell:** At a certain point, resources may become too numerous to manage via the portal, and so can be partially or completely managed via the cloud shell over Powershell or Bash. It can be accessed directly at [cloudshell.azure.com](https://cloudshell.azure.com).

Some command examples:

```sh
# az is the Azure CLI
$ az webapp list
# to create resources:
# az <target> <action>

# Create a Resource Group
$ az group create --name NewRG --location eastus

# Create a VM
$ az vm create
    --resource-group NewRG
    --name LearningVM
    --image Win2019DataCenter
    --public-ip-sku Standard
    --admin-username xXgoliathXx

# Open port 80 on the VM
az vm open-port
    --port 80
    --resource-group NewRG
    --name LearningVM

# Wipe the Resource Group
az group delete --name newrg
```

**Azure Arc:** Allows you to manage on-prem infrastructure or resouces in other clouds like GCP or AWS. SQL Servers, Kubernetes clusters, etc. Azure Stack HCI refers to edges on private clouds.

**ARM: Azure Resource Manager:** The service that runs underneath Azure Portal/CLI/Cloud Shell that can be manipulated with the aforementioned tools or a set of APIs. When creating a resource, you'll have the option to click either _create_ or a button that says **'Download a template for automation'** which presents a JSON document with all of the parameters you entered within the wizard. This is an **ARM Template**.

**ARM Templates** which describe the creation of a resource can be used in a script or added to your personal **Template Library** which will catalogue all the resource creation guides you've saved within it. Microsoft also provides a collection of common blank templates. ARM Templates are very powerful and can be tweaked and customize to completely automate deployments. They can be organized by version, and changes can be noted alongside version numbers.

## Monitoring Tools

<!-- LEARNING GOALS -->

**Learning goals:**

- Describe the purpose of Azure Advisor
- Describe Azure Service Health
- Describe Azure Monitor, including Log Analytics, Azure Monitor alerts, and Application Insights

<!-- NOTES AND CONTENT -->

**Azure Advisor** checks the resources you are using and provides cost saving recommendations. It applies common security checks to your machines and suggests common best practices and warns about vulnerable ports and addresses.

**Azure Service Health** provides information on how the _Azure Service Itself_ is running and can be **configured to send you alerts** about how the services are running globally and inform you of any outages.

**Azure Monitor** is a centralized dashboard that allows you to monitor all of your Azure services. Monitors that check things frequently will incur a cost. You can write custom queries to check all of the data that is collected by Azure about your resources in the course of running them.

From the AZ-900 course, it became clear that not only could systems be spun up with Terraforms, etc, but also ARM templates.
A section could be dedicated to findings and recipes for setting up cloud environments for legacy applications within Azure.

<!-- AZ104 -->

# AZ-104

The [AZ-104: Microsoft Azure Administrator](https://learn.microsoft.com/en-us/certifications/exams/az-104/) exam is an associate-level credential that certifies knowledge on the management of a corporate Azure subscription.

> Candidates for this exam should have subject matter expertise in implementing, managing, and monitoring an organization’s Microsoft Azure environment, including virtual networks, storage, compute, identity, security, and governance.

> An Azure administrator often serves as part of a larger team dedicated to implementing an organization's cloud infrastructure. Azure administrators also coordinate with other roles to deliver Azure networking, security, database, application development, and DevOps solutions.

I am currently working towards this credential.

# Azure Cloud Migration Summit 2023

On February 1st and 2nd 2023, I had the pleasure of attending the _Azure Cloud Migration Summit_ hosted by IBM and Microsoft. I got to hear from teams working with many interesting private and public clients. Here are some of the important things I learned from the conference.

**(All client information has been censored and/or removed.)**

IBM's _Azure Migration Factory_ process has seen great success in replatforming, moderninzing, and re-architecting client applications as they move from on-prem to Azure.

[Sudhir Jain](https://www.linkedin.com/in/sudhir-jain-4325a236/) gave a good talk on _Industry 4.0 Solutions in Manufacturing with MAS_. Smart factories can eternally stream data from sensors via Azure IoT to an Azure data lake to then be analyzed by PowerBI. IBM Maximo Visual Inspection Edge can be deployed to identify parts within picking systems and errors.

[Eric Stoltze](https://www.linkedin.com/in/ericstoltze/) of [Neudesic](https://www.neudesic.com/) gave an excellent summary of some specific client wins in the USA and abroad.

[Carmen Summers](https://www.linkedin.com/in/carmen-summers-1833901/) gave a good talk on _Solution Plays_ to assist clients with their cloud migration journey.

- Microsoft Azure sales is paid based on consumption.
- Consumption may be lowered as customers optimize their applications for the cloud, but this is **good** because the client is saving money, and is likely to remain in the cloud.
