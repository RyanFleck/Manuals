+++
date = 2023-01-03T21:55:30Z
image = ""
summary = "Microsoft's cloud services platform"
title = "Azure"
toc = true

+++

# What is Microsoft Azure?

Azure is Microsoft's cloud computing offering, enabling businesses to
run applications, databases, and other services on hardware built,
maintained, secured, and managed in Microsoft's datacenters.

> The Azure cloud platform is more than 200 products and cloud
> services designed to help you bring new solutions to life—to solve
> today’s challenges and create the future. Build, run, and manage
> applications across multiple clouds, on-premises, and at the edge,
> with the tools and frameworks of your
> choice. ([source](https://azure.microsoft.com/en-us/resources/cloud-computing-dictionary/what-is-azure))

Enterprise IT projects will commonly leverage cloud infrastructure,
making knowledge of Azure, GCP, or AWS a critical skill for
developers, software architects, and IT personnel alike.

# Learning Roadmap

As a growing Software Architect I was recommended to pursue:

![Cloud journey roadmap provided by an IBM
colleague](/uploads/azure-roadmap.png)

**Certification Checklist:**

- AZ-900 ✔
- AZ-104
- AZ-500
- AZ-305

# Azure Acronyms & Abbreviations

Sorted alphabetically.

| Key   | Value                                                 |
|-------|-------------------------------------------------------|
| ACI   | Azure Container Instance                              |
| ACO   | Actual Cut-Over                                       |
| AD-DS | Active Directory Domain Services                      |
| ADF   | Azure Data Factory                                    |
| AKS   | Azure Kubernetes Service                              |
| ARM   | Azure Resource Manager                                |
| ASG   | Application Security Group                            |
| AVD   | Azure Virtual Desktop                                 |
| AZ    | Microsoft AZure                                       |
| BLOB  | Binary Large OBject                                   |
| CM    | Configuration Management                              |
| CapEX | Capital expenditure                                   |
| DCO   | Dry Cut-Over                                          |
| DR    | Disaster Recovery                                     |
| EA    | Enterprise Architecture                               |
| ECM   | Enterprise Content Management                         |
| ECMS  | Enterprise Content Management System                  |
| GPV2  | General Purpose Storage Account V2                    |
| GRS   | Geo-Redundant Storage                                 |
| GZRS  | Geo-Zone-Redundant Storage                            |
| IaaS  | Infrastructure as a service                           |
| JEA   | Just Enough Access                                    |
| JIT   | Just in Time                                          |
| LRS   | Locally Redundant Storage                             |
| MOC   | Management of Change                                  |
| NSG   | Network Security Group                                |
| OpEX  | Operating expenditure                                 |
| PaaS  | Platform as a service                                 |
| RBAC  | Role-Based Access Control                             |
| RG    | Resource Group                                        |
| RPO   | Recovery Point Objective                              |
| RTO   | Recovery Time Objective                               |
| SA    | Storage Account                                       |
| SAS   | Shared Access Signature                               |
| SLA   | Service Level Agreeement                              |
| SMB   | Server Message Block - File and port sharing protocol |
| SME   | Subject Matter Expert                                 |
| SSO   | Single Sign-On                                        |
| SSPR  | Self-Service Password Reset                           |
| SaaS  | Software as a service                                 |
| TCO   | Total cost of ownership                               |
| TLS   | Transport Security Layer                              |
| VM    | Virtual Machine                                       |
| VMSS  | Virtual Machine Scale Set                             |
| VNet  | Virtual Network                                       |
| ZRS   | Zone-Redundant Storage                                |



```elisp
;; Sort the acronym table with M-x sort-lines
(sort-lines nil (region-beginning) (region-end))
```

# **AZ-900**: Azure Fundamentals

The [AZ-900: Microsoft Azure
Fundamentals](https://learn.microsoft.com/en-us/certifications/exams/az-900/)
exam is an entry-level credential to prove knowledge of the
fundamentals of Microsoft's Azure cloud computing platform.

> Azure Fundamentals exam is an opportunity to prove knowledge of
> cloud concepts, Azure services, Azure workloads, security and
> privacy in Azure, as well as Azure pricing and support. Candidates
> should be familiar with the general technology concepts, including
> concepts of networking, storage, compute, application support, and
> application development.

I began studying for this exam by taking an [AZ-900 prep course on
Udemy](https://www.udemy.com/course/az900-azure/) in January 2023 and
passed the in-person exam a month later.

![I received this credential on February 22nd, 2023. [Credly
badge](https://www.credly.com/badges/bf41835d-fa5a-44df-a1f5-521e3c211235).](/images/azure/azure-fundamentals-certified.png)

**Learning Goals:**

- Describe cloud concepts (25–30%)
- Describe Azure architecture and services (35–40%)
- Describe Azure management and governance (30–35%)

**Links and Resources:**

- Exam requirements:
  [learn.microsoft.com/en-us/certifications/exams/az-900](https://learn.microsoft.com/en-us/certifications/exams/az-900
  "learn.microsoft.com/en-us/certifications/exams/az-900")
- Study guide: [AZ-900 study
  guide](https://query.prod.cms.rt.microsoft.com/cms/api/am/binary/RE3VwUY)
- Practice questions: [ExamTopics AZ-900
  Q&A](https://www.examtopics.com/exams/microsoft/az-900/view/1/)

An IBM colleague warned me that **just taking the Udemy course is
insufficient to pass** the AZ-900 exam. Consider finding lots of
additional practice questions, and focus on the specific services used
to build solutions to client problems.

## Describe Cloud Computing

**Learning goals:**

- Define cloud computing
- Describe the shared responsibility model
- Define cloud models, including public, private, and hybrid
- Identify appropriate use cases for each cloud model
- Describe the consumption-based model
- Compare cloud pricing models

**Cloud computing** is the ability to rent computing resources on
demand, and only pay for what you use. Microsoft has already made the
billion-dollar investment in hardware, networking, etc.

The **Shared Responsibility Model** relates responsibilities in the
cloud environment to a traditional on-premises service deployment,
where you are responsible for everything from building and network
security to networking and firewalls to the operating systems and
authentication, devices, and data. These responsibilities fall away in
different ways if you use the cloud.

By using a **Cloud VM** (IaaS[^iaas]), you'll still need to worry
about the OS, networking, and the application, but the physical
computer and networking is handled.

[^iaas]: Acronym: **IaaS: Infrastructure as a Service:** The cloud
    provides networked hardware but does not manage the software
    running on the systems.

By using an **App Service** (PaaS[^paas]), you can now allow the cloud
service to handle operating system patches and updates.

[^paas]: Acronym: **PaaS: Platform as a Service:** Provides a basis
    for common services or easy deployment of code while the cloud
    manages the underlying OS and maintaining/monitoring the running
    software, handles upgrades and automatic deployments, etc.

At a very high level there is **Software as a Service** (SaaS[^saas])
which prohibits the control of the network and application, just
giving you access to a cloud software from a vendor.

[^saas]: Acronym: **SaaS: Software as a Service:** A managed
    application running in the cloud with no client control of the
    resources consumed by the application, deployment, etc.

With these resources, you lose some control and responsibility, and
are paying for a company (Microsoft Azure or others,) to manage those
responsibilities for you. The hope is that they manage it competently.

![A diagram with [shared
responsibility](https://learn.microsoft.com/en-us/azure/security/fundamentals/shared-responsibility)
by cloud model.](/uploads/screenshot-2023-01-03-at-4-02-01-pm.png)

**Cloud Types:**

1. **Public Cloud** -- Anybody can sign up with a credit card and use
   services right away. Azure owns the hardware and the network.
1. **Private Cloud** -- Only avaialabe to select users in a business,
   can run on a businesses' private hardware, though looks and acts
   almost like a public cloud to end users.
1. **Hybrid Cloud** -- Combination of public and private, usually a
   network interconnection between on-prem and public or private
   cloud.

On-prem, cost can be predicted by adding hardware, power, internet,
licensing, and employee costs. In the cloud, cost is based on
**consumption**, usually by a number of metrics. A database could be
priced by the CPU speed and RAM per minute, the consumed storage, an
optional dedicated gateway, and number/size of backups.

This algorithmic pricing falls into a few different categories:

1. **Free services** usually exist below a certain usage quota.
2. **Time** can be used to price many resources, ex. reserve compute
3. **Per GB** is used to price storage and network egress[^egress]
4. **Per Operation** for databases and messaging, ex. reads/writes
5. **Per Execution** for serverless functions

[^egress]: Data flowing out of a network

Pricing will also vary by **region** and **cloud**. Providers try to
price their services so it will save money for most of their client
workloads. Ideally the capital expenditure and ongoing operating
expenditures can be slowly reduced as services are moved to Azure, and
a client will be left with an overall lower operating cost after all
services are moved.

**CapEX** -- Capital Expenditure, like hardware

**OpEX** -- Ongoing Expenditure, like power and cooling

![A [Business
Case](https://learn.microsoft.com/en-us/azure/cloud-adoption-framework/strategy/cloud-migration-business-case)
for Cloud Migration.](/uploads/cloud-on-premises-comparison.png)

The cost savings comes from Microsoft's ability to run servers where
power and cooling are cheap, so they can make a profit while still
providing the computing service at a far lower TCO.

**TCO** -- Total Cost of Ownership

**Autoscaling** can be used in the cloud to ensure your resouces are
not **overprovisioned** which is the typical scenario when buying
physical hardware to avoid overloaded hardware.

## Benefits of Cloud Computing

**Learning goals:**

- Describe the benefits of high availability and scalability in the
  cloud
- Describe the benefits of reliability and predictability in the cloud
- Describe the benefits of security and governance in the cloud
- Describe the benefits of manageability in the cloud

### High Availability

Cloud services provide guarantees of reliability that use high
availability as a metric. With 44640 minutes in a 31 day month, the
following "number of nines" define the contractually allowed downtime:

1. 99.99% available: 4.464 minutes of downtime aka "four nines"
1. 99.999% available: 0.4464 minutes (26.7 seconds) of downtime
1. 99.9999% available: 0.04464 minutes (2.67 seconds) of downtime

...etc

No amount of money can achieve 100% availability.

**Scalability** -- The ability of a system to handle growth of users
or work; scaling is the ability to add capacity to an application.

**Elasticity** -- The ability of a system to automatically grow and
shrink based on application demand. Capacity is kept above user
demand.

### Reliability and Predictability

**SLA** -- Service Level Agreement: A guarantee of availability,
reliability, etc backed with financial compensation (refunds) for
failures.

Azure has published timelines and procedures for rollouts of new
hardware and software. Tools are provided to deploy applications
across multiple regions to address this scheduled downtimes.

Azure provides **Chaos Studio** to simulate various failures to see
how your application responds, adapts, or dies.

**Global Availability** can be achieved by deploying your application
across the many worldwide Azure datacenters, and this is something
that is difficult to achieve for a corporation of any scale.

### Security, Governance, Monitoring

- Security is a huge job and offloading it to the cloud reduces costs
- Azure has **AI/ML connection rejection** tech
- Azure has basic **DDOS protection** for free
- Azure provides data governance assistance to meet business and
  government/regulatory requirements around data. **Azure Blueprints**
  and **Azure Policy** can be used to automatically take actions,
  enforce rules, and create reports.
- Azure provides **monitoring of raised errors** and automation to act
  on them without human intervention

## Cloud Service Types

**Learning goals:**

- Describe infrastructure as a service (IaaS[^iaas])
- Describe platform as a service (PaaS[^paas])
- Describe software as a service (SaaS[^saas])
- Identify appropriate use cases for each cloud service (IaaS, PaaS,
  SaaS)

![A diagram showing [cloud service
types](https://learn.microsoft.com/en-us/azure/azure-sql/azure-sql-iaas-vs-paas-what-is-overview)
that can run on
Azure.](/uploads/sqliaas_sql_server_cloud_continuum.png)

**IaaS** -- Infrastructure as a Service offers compute, networking,
and storage resources on demand, where you take full responsiblity for
how your application is deployed and for most of the configuration of
the underlying resources.

**PaaS** -- Platform as a Service is a complete deployment
environment. It doesn't give access to the VM typically, but will
provide a wealth of convenience tools to support the web app
development lifecycle. Auto deployments from repositories, etc. _You
can upload code here and it will run._ Serverless functions fall into
this category but you have even less control of where things run --
you don't need to worry about scaling or the correct performance plan.

**SaaS** -- Zero control over what's going on under the hood, you just
get access to the application. Like the Azure Portal, Slack, Office
365.

## Core Architectural Components of Azure

**Learning goals:**

- Describe Azure regions, region pairs, and sovereign regions
- Describe availability zones
- Describe Azure datacenters
- Describe Azure resources and resource groups
- Describe subscriptions
- Describe management groups
- Describe the hierarchy of resource groups, subscriptions, and
  management groups

```
AZURE ARCHITECTURAL HIERARCHY 2022

Management Groups
 |__ Subscriptions
      |__ Resource Groups
           |__ Resources
```

### Regions, Region Pairs, and Sovereign Regions

**Regions** are Azure datacenters that exist in or near certain
locations in the globe.

**Region Pairs** are designed to have fast connections between
them. They are the ideal failover location for running applications. A
region pair will never have both _Regions_ down for maintenance.

For example:

1. Canada Central <-> Canada East
1. US West <-> US East
1. North Europe <-> West Europe

**Sovereign Regions** are unavailable to most Azure subscribers, like
_China_ or _Azure Government (US)_.

### Availability Zones & Datacenters

**Availability Zones** futher subdivide _Regions_. They are separate
datacenter buildings within a _Region_. They enable another layer of
failover if one datacenter in a region fails and your application is
running on multiple _AZs_.

Datacenters must be withink 50km of one another to be grouped in a
single region.

### Azure Resources and Resource Groups

**Resource Groups** are logical groupings of Azure resources typically
based on shared function.

**Resources can only be part of one group, and must be part of a
group.**

### Subscriptions & Management Groups

A **Subscription** is a billing unit. You'd want to have a
Subscription for each client that you manage. All resources that are
consumed by a subscription will be billed by the owner. Subscriptions
can also be used to break up billing into dev/production or by
department.

Subscriptions can be organized into nested **Management Groups** to
enforce policies and access.

## Azure Compute and Networking Services

**Learning goals:**

- Compare compute types, including container instances, virtual
  machines (VMs), and functions
- Describe VM options, including Azure Virtual Machines, Azure Virtual
  Machine Scale Sets (VMSS), availability sets, and Azure Virtual
  Desktop
- Describe resources required for virtual machines
- Describe application hosting options, including the Web Apps feature
  of Azure App Service, containers, and virtual machines
- Describe virtual networking, including the purpose of Azure Virtual
  Networks, Azure virtual subnets, peering, Azure DNS, Azure VPN
  Gateway, and Azure ExpressRoute
- Define public and private endpoints

### Compute Types

**Amazon EC2 (Elastic Compute Cloud) is akin to Azure VMs.** With VMs,
you can pick from a menu of different CPU types, paired with different
amounts of memory and
storage. [menu](https://azure.microsoft.com/en-ca/pricing/details/virtual-machines/windows/)

**VM Scale Sets** are a functionality provided for free, though you do
need to pay for the consumed vm-hour-storage-memory units. Enables 2+
machines to run the same code and autoscale with more machines (up to
100 by default or 1000 configured.)

**App Services** (PaaS) runs an application with no knowledge of the
underlying hardware apart from basic specs, like Heroku.

**Azure Container Instance (ACI)** can run a single container or a
group of containers with Docker Compose.

**Azure Kubernetes Service (AKS)** can run a cluster of containers.

**Azure Virtual Desktop (AVD)** provides a virtual desktop for work
purposes.

### Networking Services

**Virtual Networks** or **Virtual Private Clouds (VPC) on AWS**
emulate a physical network and allow you to work remotely or combine
physical networks.  Creating interconnected virtual networks or
**subnets** with different security settings in Azure is just a
software configuration called _peering_ as it is all networked
physically.

**Address Spaces** define the number of available IP addresses in your
VNet, 10.0.0.0/16 indicates a 16 bit subnet mask, giving you the last
16 bits in the address for your IPs (~65k with a 16 bit subnet mask.)

**VPN Gateways** allow you to connect networks together, between
on-prem and Azure or your local machine to your business network.

**VNet Peering** enables the interconnection of vnets.  One-way and
two-way traffic can be configured between peered subnets. Global
peering is possible but costs money for bandwidth: egress from zone A,
and ingress to zone B.

**Private Endpoints** allow you to make a resource accessible only at
a [specific IP on a virtual
network](https://learn.microsoft.com/en-us/azure/private-link/private-endpoint-overview).

**ExpressRoute** is a high speed PHYSICAL CABLE private connection to
Azure.

**Azure DNS** allows you to take control of the DNS records for your
domain.

## Azure Storage Services

**Learning goals:**

- Compare Azure storage services
- Describe storage tiers
- Describe redundancy options
- Describe storage account options and storage types
- Identify options for moving files, including AzCopy, Azure Storage
  Explorer, and Azure File Sync
- Describe migration options, including Azure Migrate and Azure Data
  Box

Blob, disk, file storage.

In an **Azure Storage** account, the most common storage type is
general purpose v2 (**GPV2**) which can hold blobs, tables, queues,
and files. It's the cheapest as well at roughly 2 cents per GB.  This
is equivalent to **AWS S3**.

**BLOB = Binary Large OBject**

**Blob or Unmanaged Storage** like gpv2 allows you to store objects
and be charged by size and egress. Blob storage is organized into
_containers_ and the access tier, block size,
[endpoints,](https://learn.microsoft.com/en-us/azure/storage/common/storage-account-overview#standard-endpoints)
etc can be set on a per-container basis in a storage
account. Temporary permissions can be generated for a blob by creating
an [SAS
key](https://learn.microsoft.com/en-us/azure/storage/blobs/sas-service-create?tabs=dotnet)
that allows you to read or write, etc.

**Disk Storage** allows you to take control of a full pre-allocated
disk, and you pay for the disk size and speed regardless of usage.

**Access tiers** - hot, cool, archive -- the cool tier is half the
price, but is slower and costs more to access. Archive tier is ~10% of
the cost of hot storage, but may take hours to access.

Performance tiers - premium, standard

Location - keep close to your application instances

**Redundancy** - multiple replicated copies of files in different
regions. Options include:

1. **LRS** -- Locally-redundant storage, multiple disks in one
   datacenter, the default.
1. **GRS** -- Geo-redundant storage, disks in different regions, good
   for backups.
1. **ZRS** -- Zone-redundant storage, disks in different zones, good
   for high availability.
1. **GZRS** -- Geo-zone-redundant storage, good for critical data.

Failover - automatically using a storage backup

**Data Lake Storage Gen 2** enables hierarchical namespaces and access
to parts of a ludicrously large virtual filesystem.

**To move files, there are four options available:**

1. Blob container view, for development.
2. **Azure Storage Explorer/Browser** which allows you to see all
   files in a storage account and manipulate them.
3. **AzCopy** allows you to copy data between storage accounts on the
   Azure network to prevent egress and ingress fees. It can run within
   the Azure cloud shell, or locally to move things to and from the
   cloud. With a blob SAS and container SAS, you can copy a blob to a
   new container. You can even copy from other clouds or anything with
   a URL.
4. **Azure File Sync** is uses to synchronize on-premise disks with
   **cloud file shares**. Fileshares are typically connected to via
   the
   [SMB](https://learn.microsoft.com/en-us/windows/win32/fileio/microsoft-smb-protocol-and-cifs-protocol-overview)
   protocol, [NTLM
   v2](https://learn.microsoft.com/en-us/windows-server/security/kerberos/ntlm-overview)
   authentication, and [AES-128-GCM](https://www.aes-gcm.com/)
   encryption. To set this up with a storage account, add a storage
   sync service, and install the file sync agent on the target.

```ps1
# PowerShell (.ps1) AZCopy Example

azcopy -?  # see if it's installed

azcopy copy '<url to source>' '<url to dest>'
```

**Migration Tools and Strategies:**

1. **Azure Migrate** is a guided experience for IT to migrate their
   resources to the cloud. It includes tools to _map your current
   environment_ so you'll know what you need to provision in
   Azure. The tool will make recommendations and raise flags if
   current tech is unable to be moved in a conventional/easy way.
2. **Azure Data Box** is for scenarios where massive volumes
   (Terabytes to Petabytes) of data must be moved to the cloud. Data
   boxes range in size from a single SSD (8TB) to a box (100TB) to a
   "Data Box Heavy" on wheels (1PB). The data will be shipped
   encrypted and uploaded to your account when it arrives.

![Options for migrating data to Azure.](/uploads/data-box.png)

## Identity, Access, and Security

<!-- LEARNING GOALS -->

**Learning goals:**

- Describe directory services in Azure, including Microsoft Azure
  Active Directory (Azure AD), part of Microsoft Entra and Azure
  Active Directory Domain Services (Azure AD DS)
- Describe authentication methods in Azure, including single sign-on
  (SSO), multifactor authentication, and passwordless
- Describe external identities and guest access in Azure
- Describe Conditional Access in Microsoft Azure Active Directory
  (Azure AD), part of Microsoft Entra
- Describe Azure role-based access control (RBAC)
- Describe the concept of Zero Trust
- Describe the purpose of the defense in depth model
- Describe the purpose of Microsoft Defender for Cloud

<!-- NOTES AND CONTENT -->

Generally, **identity** is a digital representation of an entity that
requires access to a system. This could be a person, device, or
robot/application. Digital identity requires proof such as a key,
password, or certificate.

**Authentication:** who are you?

**Authorization:** what are you allowed to do?

**Azure AD** is a security protocol used on Azure. It is **identity as
a service** (idaas? lol.)  Much like OAuth, the web server is passed a
signed/trusted token it can use to identify the user.

![Using Azure AD means skipping writing a complex security system, as
AAD includes
[MFA](https://learn.microsoft.com/en-us/azure/active-directory/authentication/overview-authentication)
and plenty of other security measures built
in.](/images/azure/authenticationflow.png)

Azure AD offers a centralized, consistent, secure approach to using
your org's applications, and even many applications outside your
organization or SaaS offerings.

AAD has the ability to configure **conditional access** which detects
_unusual logins_ and can block access or ask for additional
information. For example, is the user on the company network? Have
they not logged in for years? AAD calls these _signals_.

**MFA: Multi-Factor Authentication** -- Requires _two or more_ pieces
of evidence that the user is not an impostor. This can be something
you **know** (password), something you **have** (phone), or something
you **are** (biometric artifact).

**Passwordless authentication** attempts to reduce the inconvenience
of MFA while retaining the security benefits. Essentially MFA without
passwords as an auth option. Can be simple games while carefully
checking _signals_ like the device.

Azure **RBAC** (role based access control) allows administrators to
enable granular access to all the Azure services for a variety of
roles. Readonly to storage for business roles, control over virtual
machines for developers, the ability to create and destroy VMs and
storage for developer admins, etc. It's easy to create custom
permissions and roles. It is rare to manage permissions on an
individual level, it is far more common to use roles.

**Common Azure Permissions:**

1. **Reader** -- Can read
1. **Contributor** -- Can read and write
1. **Owner** -- Can assign permissions to other users

**Zero Trust** means providing many security thresholds within a
service or between applications, with everything locked by default,
only enabling access to exactly what is needed to complete work. The
principles of zero trust are:

1. Verify explicitly
1. Use least privileged access
1. Assume [your network has been] breached

**JIT:** Just in Time -- only grant permissions when needed

**JEA:** Just Enough Access -- don't over-provision access

![A map of Microsoft's [zero
trust](https://www.microsoft.com/en-us/security/business/zero-trust)
policy security model.](/images/azure/security-policy.png)

1. **Applications** should have appropriate user powers and monitor
   users.
1. **Data** should be encrypted and access should be restricted
1. **Infrastructure** should be monitored to detect attacks and
   unusual usage

Provide ample security within the network: encryption, segmentation,
threat detection, etc.

The **Defense in Depth** principle means applying security best
practices at every level of an organization:

1. Physical -- locks and room access
1. Identity -- Azure AD
1. Network -- ddos, firewalls, subnets, deny by default
1. Compute -- limit RDP use, access, keep servers up to date
1. Apps -- APIs are well written and secure
1. Data -- Tightly scoped vnet access

Azure provides many tools for each category.

![Sample _defense in depth_ slide showing security
layers.](/images/azure/defense-in-depth.jpg)

**Microsoft Defender for Cloud** provides security, posture
management, and threat detection. By paying per resource per month
(~$15USD per server) Microsoft provides an in-depth security analysis
and monitoring of the resource.

## Azure Cost Management

<!-- LEARNING GOALS -->

**Learning goals:**

- Describe factors that can affect costs in Azure
- Compare the Pricing calculator and the Total Cost of Ownership (TCO)
  calculator
- Describe the Azure Cost Management and Billing tool
- Describe the purpose of tags

<!-- NOTES AND CONTENT -->

Billing is calculated from a broad variety of factors depending on the
service. Many services have a free tier or are free below a certain
limit, like virtual networks, load balancing, basic AAD, and free-tier
web apps. Using pay-by-consumption or serverless models can save
organizations a lot of money -- one million executions of an Azure
Function will cost ~$0.20 USD. Per second billing is used for
resources like VMs and disks.

Pricing can be made more stable with a 1 -> 3 year commitment in
reserved VM instances. Long-term contracts can be made to reduce
storage, VM, networking costs.

**Azure is priced to increase cloud utilization.**

Ingress (inbound data) is almost always **free** for obvious reasons.

1PB of data would cost **~$52,000 USD** to remove from Azure.

The Azure [Pricing
Calculator](https://azure.microsoft.com/en-ca/pricing/calculator/)
allows consultants to make an educated guess about the costs of a
service.  As Azure's pricing changes, the cost of provisioned services
will change, so the pricing calculator must be used with this in mind.

![The 2022 **Azure Pricing Calculator**
homepage.](/images/azure/pricing-calculator-1.png)

![The calculator provides common
scenarios.](/images/azure/pricing-calculator-2.png)

**TCO: Total Cost of Ownership** can be estimated with the [Azure TCO
Calculator](https://azure.microsoft.com/en-ca/pricing/tco/calculator/)
and is oriented towards comparing current on-prem costs with a
potential Azure re-deployment. It attempts to factor in power,
networking costs, hardware costs, software licenses, and IT personnel
costs to determine if the client will attain a _hybrid benefit_ from
moving some or all of their workload to Azure.

**Resource Tags** can be used to organize which department the bills
for a certain resource are sent. Tags can be used for many other
things, but they are particularly useful for billing as dashboards can
show cost by tag.

_\*BRRRING!\* \*BRRRING!\* \*CLICK!\* \*SHFHFHFUF-FLE-SHUFFLFL!\*_

**HELLO SIR** YOU HAVE REACHED **THE BILLING DEPARTMENT SIR** WHAT IS
YOUR BILLING CODE SIR!?  **SIR!? ARE YOU THERE SIR!?!?** HELLO???
SIR!?

_\*CLICK!\*_

### Dashboards for Cost Management & Billing

Running costs can be viewed and analyzed with free Azure
tools. Budgets can be specified, payments tracked, and recommendations
given by the system. The dashboard can provide spending estimates and
configurable alerts.

![An [example
dashboard](https://azure.microsoft.com/en-us/products/cost-management/#overview)
showing spending analytics.](/images/azure/azure-cost-mgmt.png)

Reports can be scheduled showing resource usage.

## Azure Governanace and Compliance

<!-- LEARNING GOALS -->

**Learning goals:**

- Describe the purpose of Azure Blueprints
- Describe the purpose of Azure Policy
- Describe the purpose of resource locks
- Describe the purpose of the Service Trust Portal

A company may have certain IT rules that they want to implement. Azure
provides a variety of tools to enforce these policies
programmatically. For instance: _Ensure all servers have at least one
daily backup._

This rule can either be enforced socially, with an email to IT, or
programmatically in Azure, with tools like those listed in the
learning goals above which will now be explored.

**Azure Blueprint** provides a way to standardize the creation and
management of subscriptions. It can create and enforce security rules,
resource groups, and policies across a set of subscriptions that can
be per client or just per department.

**Azure Policy** provides a way to programmatically define and enforce
these rules. For example, you can mandate:

- A mininum SQL server version
- Limit which virtual machine SKUs can be used
- Define required tags and their default values

You can also _write your own policies_ to help prevent unsafe
practices and limit costs.

**Resource Locks:** You can mark a resouce as read only to ensure
other users cannot modify the state of the VM, delete it, or modify
its properties. You can ensure only a limited subset of people can
apply and remove locks.

The **Service Trust Portal** holds all the
[documents](https://servicetrust.microsoft.com) related to Azure's
compliance towards regulations and standards. It even contains
**blueprints** for certain applications and industries, like
healthcare or US Government.

<!-- NOTES AND CONTENT -->

## Tools for Managing and Deploying Azure Resources

<!-- LEARNING GOALS -->

**Learning goals:**

- Describe the Azure portal
- Describe Azure Cloud Shell, including Azure CLI and Azure PowerShell
- Describe the purpose of Azure Arc
- Describe Azure Resource Manager and Azure Resource Manager templates
  (ARM templates)

<!-- NOTES AND CONTENT -->

**Azure Portal:** Available at portal.azure.com, Microsoft provides a
web GUI for creating and managing all Azure resources.

**Azure Cloud Shell, CLI, Powershell:** At a certain point, resources
may become too numerous to manage via the portal, and so can be
partially or completely managed via the cloud shell over Powershell or
Bash. It can be accessed directly at
[cloudshell.azure.com](https://cloudshell.azure.com).

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

**Azure Arc:** Allows you to manage on-prem infrastructure or resouces
in other clouds like GCP or AWS. SQL Servers, Kubernetes clusters,
etc. Azure Stack HCI refers to edges on private clouds.

**ARM: Azure Resource Manager:** The service that runs underneath
Azure Portal/CLI/Cloud Shell that can be manipulated with the
aforementioned tools or a set of APIs. When creating a resource,
you'll have the option to click either _create_ or a button that says
**'Download a template for automation'** which presents a JSON
document with all of the parameters you entered within the
wizard. This is an **ARM Template**.

**ARM Templates** which describe the creation of a resource can be
used in a script or added to your personal **Template Library** which
will catalogue all the resource creation guides you've saved within
it. Microsoft also provides a collection of common blank
templates. ARM Templates are very powerful and can be tweaked and
customize to completely automate deployments. They can be organized by
version, and changes can be noted alongside version numbers.

## Monitoring Tools

<!-- LEARNING GOALS -->

**Learning goals:**

- Describe the purpose of Azure Advisor
- Describe Azure Service Health
- Describe Azure Monitor, including Log Analytics, Azure Monitor
  alerts, and Application Insights

<!-- NOTES AND CONTENT -->

**Azure Advisor** checks the resources you are using and provides cost
saving recommendations. It applies common security checks to your
machines and suggests common best practices and warns about vulnerable
ports and addresses.

**Azure Service Health** provides information on how the _Azure
Service Itself_ is running and can be **configured to send you
alerts** about how the services are running globally and inform you of
any outages.

**Azure Monitor** is a centralized dashboard that allows you to
monitor all of your Azure services. Monitors that check things
frequently will incur a cost. You can write custom queries to check
all of the data that is collected by Azure about your resources in the
course of running them.

From the AZ-900 course, it became clear that not only could systems be
spun up with Terraforms, etc, but also ARM templates.  A section could
be dedicated to findings and recipes for setting up cloud environments
for legacy applications within Azure.

<!-- AZ104 -->

# **AZ-104**: Azure Administrator

The [AZ-104: Microsoft Azure
Administrator](https://learn.microsoft.com/en-us/certifications/exams/az-104/)
exam is an associate-level credential that certifies knowledge on the
management of a corporate Azure subscription.

> Candidates for this exam should have subject matter expertise in
> implementing, managing, and monitoring an organization’s Microsoft
> Azure environment, including virtual networks, storage, compute,
> identity, security, and governance.

> An Azure administrator often serves as part of a larger team
> dedicated to implementing an organization's cloud
> infrastructure. Azure administrators also coordinate with other
> roles to deliver Azure networking, security, database, application
> development, and DevOps solutions.

I am currently working towards this credential.

View the [AZ-104 Study
Guide](https://learn.microsoft.com/en-us/credentials/certifications/resources/study-guides/az-104).

**Topics:**

- Manage Azure Identities And Governance (20–25%)
- Implement And Manage Storage (15–20%)
- Deploy And Manage Azure Compute Resources (20–25%)
- Implement And Manage Virtual Networking (15–20%)
- Monitor And Maintain Azure Resources (10–15%)


## Manage Microsoft Entra Users And Groups
### Create Users And Groups
### Manage User And Group Properties
### Manage Licenses In Microsoft Entra ID
### Manage External Users
### Configure Self-Service Password Reset (SSPR)



## Manage Access To Azure Resources
### Manage Built-In Azure Roles
### Assign Roles At Different Scopes
### Interpret Access Assignments



## Manage Azure Subscriptions And Governance
### Implement And Manage Azure Policy
### Configure Resource Locks
### Apply And Manage Tags On Resources
### Manage Resource Groups
### Manage Subscriptions
### Manage Costs By Using Alerts, Budgets, and Advisor
### Configure Management Groups




## Configure Access To Storage

Section 8 in [AZ-104 Udemy Course](https://www.udemy.com/course/70533-azure/).

### Configure Azure Storage Firewalls And Virtual Networks
### Create And Use Shared Access Signature (SAS) Tokens
### Configure Stored Access Policies
### Manage Access Keys
### Configure Identity-Based Access For Azure Files



## Configure And Manage Storage Accounts
### Create And Configure Storage Accounts
### Configure Azure Storage Redundancy


| Level | Distribution of Files      |
|-------|----------------------------|
| LRS   | Locally-Redundant Storage  |
| GRS   | Geo-Redundant Storage      |
| ZRS   | Zone-Redundant Storage     |
| GZRS  | Geo-Zone-Redundant Storage |

| Access Tier           | Use Case                                        |
|-----------------------|-------------------------------------------------|
| Transaction Optimized | Transaction-heavy workloads with higher latency |
| Hot                   | Frequently accessed data                        |
| Cool                  |                                                 |
| Cold                  |                                                 |
| Archive               |                                                 |
|                       |                                                 |


### Configure Object Replication
### Configure Storage Account Encryption
### Manage Data By Using Azure Storage Explorer And AzCopy



## Configure Azure Files And Azure Blob Storage
### Create And Configure A File Share In Azure Storage
### Create And Configure A Container In Blob Storage
### Configure Storage Tiers
### Configure Snapshots And Soft Delete For Azure Files
### Configure Blob Lifecycle Management
### Configure Blob Versioning



## Automate Deployment Of Resources By Using ARM Templates Or Bicep Files
### Interpret An Azure Resource Manager Template Or A Bicep File
### Modify An Existing Azure Resource Manager Template
### Modify An Existing Bicep File
### Deploy Resources By Using An Azure Resource Manager Template Or A Bicep File
### Export A Deployment As An ARM Template Or Convert An ARM File To A Bicep File



## Create And Configure Virtual Machines
### Create A Virtual Machine
### Configure Azure Disk Encryption
### Move A Virtual Machine To Another Resource Group, Subscription, Or Region
### Manage Virtual Machine Sizes
### Manage Virtual Machine Disks
### Deploy Virtual Machines To Availability Zones And Availability Sets
### Deploy And Configure An Azure Virtual Machine Scale Sets



## Provision And Manage Containers In The Azure Portal
### Create And Manage An Azure Container Registry
### Provision A Container By Using Azure Container Instances
### Provision A Container By Using Azure Container Apps
### Manage Sizing And Scaling For Containers, Including Azure Container Instances/Apps



## Create And Configure Azure App Service
### Provision An App Service Plan
### Configure Scaling For An App Service Plan
### Create An App Service
### Configure Certificates And Transport Layer Security (TLS) For An App Service
### Map An Existing Custom DNS Name To An App Service
### Configure Backup For An App Service
### Configure Networking Settings For An App Service
### Configure Deployment Slots For An App Service



## Configure And Manage Virtual Networks In Azure
### Create And Configure Virtual Networks And Subnets
### Create And Configure Virtual Network Peering
### Configure Public IP Addresses
### Configure User-Defined Network Routes
### Troubleshoot Network Connectivity



## Configure Secure Access To Virtual Networks
### Create And Configure NSGs and ASGs

- Network Security Groups (NSGs)
- Application Security Groups (ASGs)

### Evaluate Effective Security Rules In NSGs
### Implement Azure Bastion
### Configure Service Endpoints For Azure Platform As A Service (PaaS)
### Configure Private Endpoints For Azure PaaS



## Configure Name Resolution And Load Balancing
### Configure Azure DNS
### Configure An Internal Or Public Load Balancer
### Troubleshoot Load Balancing




## Monitor Resources In Azure
### Interpret Metrics In Azure Monitor
### Configure Log Settings In Azure Monitor
### Query And Analyze Logs In Azure Monitor
### Set Up Alert Rules, Action Groups, And Alert Processing Rules In Azure Monitor
### Configure And Interpret Monitoring Of Virtual Machines, Storage Accounts, And Networks By Using Azure Monitor Insights
### Use Azure Network Watcher And Connection Monitor



## Implement Backup And Recovery
### Create A Recovery Services Vault
### Create An Azure Backup Vault
### Create And Configure A Backup Policy
### Perform Backup And Restore Operations By Using Azure Backup
### Configure Azure Site Recovery For Azure Resources
### Perform A Failover To A Secondary Region By Using Site Recovery
### Configure And Interpret Reports And Alerts For Backups




## AZ-104 Resources

1. [Azure documentation](https://learn.microsoft.com/en-us/azure/?product=featured)
1. [Microsoft Entra ID](https://learn.microsoft.com/en-us/azure/active-directory/)
1. [Azure Policy](https://learn.microsoft.com/en-us/azure/governance/policy/)
1. [Azure Storage](https://learn.microsoft.com/en-us/azure/storage/)
1. [Azure Storage Explorer](https://learn.microsoft.com/en-us/azure/vs-azure-tools-storage-manage-with-storage-explorer)
1. [Azure Blob Storage](https://learn.microsoft.com/en-us/azure/storage/blobs/)
1. [ARM templates](https://learn.microsoft.com/en-us/azure/azure-resource-manager/templates/)
1. [Azure Container Instances](https://learn.microsoft.com/en-us/azure/container-instances/)
1. [Azure Container Apps](https://learn.microsoft.com/en-us/azure/container-apps/)
1. [App Service](https://learn.microsoft.com/en-us/azure/app-service/)
1. [Azure DNS](https://learn.microsoft.com/en-us/azure/dns/)
1. [Azure Bastion](https://learn.microsoft.com/en-us/azure/bastion/)
1. [Application Gateway](https://learn.microsoft.com/en-us/azure/application-gateway/)
1. [Azure Monitor](https://learn.microsoft.com/en-us/azure/azure-monitor/)
1. [Network Watcher](https://learn.microsoft.com/en-us/azure/network-watcher/)
1. [Azure Site Recovery](https://learn.microsoft.com/en-us/azure/site-recovery/)
1. [Azure Backup service](https://learn.microsoft.com/en-us/azure/backup/)

# **AZ-500**: Azure Security Technologies

View the [AZ-500 Study Guide](https://learn.microsoft.com/en-us/credentials/certifications/resources/study-guides/az-500).

**Topics**:

- Manage Identity And Access (25–30%)
- Secure Networking (20–25%)
- Secure Compute, Storage, And Databases (20–25%)
- Manage Security Operations (25–30%)




## Manage Microsoft Entra Identities
### Secure Microsoft Entra Users
### Secure Microsoft Entra Groups
### Recommend When To Use External Identities
### Secure External Identities
### Implement Microsoft Entra ID Protection



## Manage Microsoft Entra Authentication
### Configure Microsoft Entra Verified ID
### Implement Multi-Factor Authentication (MFA)
### Implement Passwordless Authentication
### Implement Password Protection
### Implement Single Sign-On (SSO)
### Integrate Single Sign On (SSO) And Identity Providers
### Recommend And Enforce Modern Authentication Protocols



## Manage Microsoft Entra Authorization
### Configure Azure Role Permissions For Management Groups, Subscriptions, Resource Groups, And Resources
### Assign Microsoft Entra Built-In Roles
### Assign Azure Built-In Roles
### Create And Assign Custom Roles, Including Azure Roles And Microsoft Entra Roles
### Implement And Manage Microsoft Entra Permissions Management
### Configure Microsoft Entra Privileged Identity Management
### Configure Role Management And Access Reviews In Microsoft Entra
### Implement Conditional Access Policies



## Manage Microsoft Entra Application Access
### Manage Access To Enterprise Applications In Microsoft Entra ID, Including OAuth Permission Grants
### Manage Microsoft Entra App Registrations
### Configure App Registration Permission Scopes
### Manage App Registration Permission Consent
### Manage And Use Service Principals
### Manage Managed Identities For Azure Resources
### Recommend When To Use And Configure An Microsoft Entra Application Proxy, Including Authentication




## Plan And Implement Security For Virtual Networks
### Plan And Implement Network Security Groups (NSGs) And Application Security Groups (ASGs)
### Plan And Implement User-Defined Routes (UDRs)
### Plan And Implement Virtual Network Peering Or VPN Gateway
### Plan And Implement Virtual WAN, Including Secured Virtual Hub
### Secure VPN Connectivity, Including Point-To-Site And Site-To-Site
### Implement Encryption Over ExpressRoute
### Configure Firewall Settings On PaaS Resources
### Monitor Network Security By Using Network Watcher, Including NSG Flow Logging



## Plan And Implement Security For Private Access To Azure Resources
### Plan And Implement Virtual Network Service Endpoints
### Plan And Implement Private Endpoints
### Plan And Implement Private Link Services
### Plan And Implement Network Integration For Azure App Service And Azure Functions
### Plan And Implement Network Security Configs For An App Service Environment (ASE)
### Plan And Implement Network Security Configs For A SQL Managed Instance



## Plan And Implement Security For Public Access To Azure Resources
### Plan And Implement Transport Layer Security (TLS) To Applications, Including Azure App Service And API Management
### Plan, Implement, And Manage An Azure Firewall, Including Azure Firewall Manager And Firewall Policies
### Plan And Implement An Azure Application Gateway
### Plan And Implement An Azure Front Door, Including Content Delivery Network (CDN)
### Plan And Implement A Web Application Firewall (WAF)
### Recommend When To Use Azure DDoS Protection Standard




## Plan And Implement Advanced Security For Compute
### Plan And Implement Remote Access To Public Endpoints, Including Azure Bastion And Just-In-Time (JIT) Virtual Machine (VM) Access
### Configure Network Isolation For Azure Kubernetes Service (AKS)
### Secure And Monitor AKS
### Configure Authentication For AKS
### Configure Security Monitoring For Azure Container Instances (ACIs)
### Configure Security Monitoring For Azure Container Apps (ACAs)
### Manage Access To Azure Container Registry (ACR)
### Configure Disk Encryption, Including Azure Disk Encryption (ADE), Encryption As Host, And Confidential Disk Encryption
### Recommend Security Configurations For Azure API Management



## Plan And Implement Security For Storage
### Configure Access Control For Storage Accounts
### Manage Life Cycle For Storage Account Access Keys
### Select And Configure An Appropriate Method For Access To Azure Files
### Select And Configure An Appropriate Method For Access To Azure Blob Storage
### Select And Configure An Appropriate Method For Access To Azure Tables
### Select And Configure An Appropriate Method For Access To Azure Queues
### Select And Configure Appropriate Methods For Protecting Against Data Security Threats, Including Soft Delete, Backups, Versioning, And Immutable Storage
### Configure Bring Your Own Key (BYOK)
### Enable Double Encryption At The Azure Storage Infrastructure Level



## Plan And Implement Security For SQL Database and Managed Instances
### Enable Microsoft Entra Database Authentication
### Enable Database Auditing
### Identify Use Cases For The Microsoft Purview Governance Portal
### Implement Data Classification Of Sensitive Information By Using The Microsoft Purview Governance Portal
### Plan And Implement Dynamic Masking
### Implement Transparent Database Encryption (TDE)
### Recommend When To Use Azure SQL Database Always Encrypted




## Plan, Implement, And Manage Governance For Security
### Create, Assign, And Interpret Security Policies And Initiatives In Azure Policy
### Configure Security Settings By Using Azure Blueprints
### Deploy Secure Infrastructures By Using A Landing Zone
### Create And Configure An Azure Key Vault
### Recommend When To Use A Dedicated Hardware Security Module (HSM)
### Configure Access To Key Vault, Including Vault Access Policies And Azure Role Based Access Control
### Manage Certificates, Secrets, And Keys
### Configure Key Rotation
### Configure Backup And Recovery Of Certificates, Secrets, And Keys



## Manage Security Posture By Using Microsoft Defender For Cloud
### Identify And Remediate Security Risks By Using The Microsoft Defender For Cloud Secure Score And Inventory
### Assess Compliance Against Security Frameworks And Microsoft Defender For Cloud
### Add Industry And Regulatory Standards To Microsoft Defender For Cloud
### Add Custom Initiatives To Microsoft Defender For Cloud
### Connect Hybrid Cloud And Multi-Cloud Environments To Microsoft Defender For Cloud
### Identify And Monitor External Assets By Using Microsoft Defender External Attack Surface Management



## Configure And Manage Threat Protection By Using Microsoft Defender For Cloud
### Enable Workload Protection Services In Microsoft Defender For Cloud, Including Microsoft Defender For Storage, Databases, Containers, App Service, Key Vault, Resource Manager, And DNS
### Configure Microsoft Defender For Servers
### Configure Microsoft Defender For Azure SQL Database
### Manage And Respond To Security Alerts In Microsoft Defender For Cloud
### Configure Workflow Automation By Using Microsoft Defender For Cloud
### Evaluate Vulnerability Scans From Microsoft Defender For Server



## Configure And Manage Security Monitoring And Automation Solutions
### Monitor Security Events By Using Azure Monitor
### Configure Data Connectors In Microsoft Sentinel
### Create And Customize Analytics Rules In Microsoft Sentinel
### Evaluate Alerts And Incidents In Microsoft Sentinel
### Configure Automation In Microsoft Sentinel




## AZ-500 Resources

1. [Azure documentation](https://learn.microsoft.com/en-us/azure/?product=featured)
1. [Microsoft Entra ID](https://learn.microsoft.com/en-us/azure/active-directory/)
1. [Azure Firewall documentation](https://learn.microsoft.com/en-us/azure/firewall/)
1. [Azure Firewall Manager documentation](https://learn.microsoft.com/en-us/azure/firewall-manager/)
1. [Azure Application Gateway documentation](https://learn.microsoft.com/en-us/azure/application-gateway/)
1. [Azure Front Door and CDN Documentation](https://learn.microsoft.com/en-us/azure/frontdoor/)
1. [Web Application Firewall documentation](https://learn.microsoft.com/en-us/azure/web-application-firewall/)
1. [Azure Key Vault documentation](https://learn.microsoft.com/en-us/azure/key-vault/)
1. [Virtual network service endpoint policies for Azure Storage](https://learn.microsoft.com/en-us/azure/virtual-network/virtual-network-service-endpoint-policies-overview)
1. [Manage Azure Private Endpoints - Azure Private Link](https://learn.microsoft.com/en-us/azure/private-link/manage-private-endpoint?tabs=manage-private-link-powershell)
1. [Create a Private Link service by using the Azure portal](https://learn.microsoft.com/en-us/azure/private-link/create-private-link-service-portal)
1. [Azure DDoS Protection documentation](https://learn.microsoft.com/en-us/azure/ddos-protection/)
1. [Virtual machines in Azure](https://learn.microsoft.com/en-us/azure/virtual-machines/overview)
1. [Secure and use policies on virtual machines in Azure](https://learn.microsoft.com/en-us/azure/virtual-machines/security-policy)
1. [Security - Azure App Service](https://learn.microsoft.com/en-us/azure/app-service/overview-security)
1. [Azure Policy documentation](https://learn.microsoft.com/en-us/azure/governance/policy/)
1. [Plan your Defender for Servers deployment](https://learn.microsoft.com/en-us/azure/defender-for-cloud/defender-for-servers-introduction)
1. [Microsoft Defender for Cloud documentation](https://learn.microsoft.com/en-us/azure/defender-for-cloud/)
1. [Microsoft Threat Modeling Tool overview](https://learn.microsoft.com/en-us/azure/security/develop/threat-modeling-tool)
1. [Azure Monitor documentation](https://learn.microsoft.com/en-us/azure/azure-monitor/)
1. [Microsoft Sentinel documentation](https://learn.microsoft.com/en-us/azure/sentinel/)
1. [Azure Storage documentation](https://learn.microsoft.com/en-us/azure/storage/)
1. [Azure Files documentation](https://learn.microsoft.com/en-us/azure/storage/files/)
1. [Azure SQL documentation](https://learn.microsoft.com/en-us/azure/azure-sql/?view=azuresql)


# **AZ-305**: Designing Azure Infrastructure Solutions 

The
[AZ-305](https://learn.microsoft.com/en-us/credentials/certifications/exams/az-305/) 
course covers the design of cloud and hybrid solutions leveraging Azure.

This course has replaced AZ-303 and AZ-304.

# Azure Cloud Migration Summit 2023

On February 1st and 2nd 2023, I had the pleasure of attending the
_Azure Cloud Migration Summit_ hosted by IBM and Microsoft. I got to
hear from teams working with many interesting private and public
clients. Here are some of the important things I learned from the
conference.

**(All client information has been censored and/or removed.)**

IBM's _Azure Migration Factory_ process has seen great success in
replatforming, moderninzing, and re-architecting client applications
as they move from on-prem to Azure.

[Sudhir Jain](https://www.linkedin.com/in/sudhir-jain-4325a236/) gave
a good talk on _Industry 4.0 Solutions in Manufacturing with
MAS_. Smart factories can eternally stream data from sensors via Azure
IoT to an Azure data lake to then be analyzed by PowerBI. IBM Maximo
Visual Inspection Edge can be deployed to identify parts within
picking systems and errors.

[Eric Stoltze](https://www.linkedin.com/in/ericstoltze/) of
[Neudesic](https://www.neudesic.com/) gave an excellent summary of
some specific client wins in the USA and abroad.

[Carmen Summers](https://www.linkedin.com/in/carmen-summers-1833901/)
gave a good talk on _Solution Plays_ to assist clients with their
cloud migration journey.

- Microsoft Azure sales is paid based on consumption.
- Consumption may be lowered as customers optimize their applications
  for the cloud, but this is **good** because the client is saving
  money, and is likely to remain in the cloud.

# Formatting MS Study Guides

Using EMACS, it is easy to transform a study guide to a template for
study notes.

To take a study guide and transform it to markdown headings:

```
M-x flush-lines ^$
M-x repla
```

**Command History:**

```elisp
(flush-lines "^$" nil nil t)
(replace-regexp "^" "^# " nil 33712 38549 nil nil)
(replace-regexp "^#     " "## " nil 33805 33997 nil nil)
```


