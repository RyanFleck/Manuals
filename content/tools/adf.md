+++
date = 2023-01-03T21:55:30Z
summary = "A data engineering platform"
title = "Azure Data Factory"
toc = true
aliases = ["data-factory", "azdf", "azure-data-factory", "ADF"]
+++

# What is a Data Factory?

During my time at a client, I made extensive use of **Azure Data
Factory** to move and transform data. This tool, backed by Spark
clusters, is highly useful for moving terabytes of data at once or
on a schedule.

[See all my *other* Azure notes in the **Azure Manual**.]({{< ref "/tools/azure.md" >}})

- Udemy Course: [Masterclass on Azure Data Factory 2024](https://ibm-learning.udemy.com/course/azure-data-factory-data-engineer-real-time-projects/learn/lecture/37092926#overview)
- MS Docs: [Data Factory Pipelines & Activities](https://learn.microsoft.com/en-us/azure/data-factory/concepts-pipelines-activities?tabs=data-factory)

**Key Concepts:**

1. Pipelines
   - A logical group of activities
2. Activities
   - Can take zero or more input datasets
   - Produces one or more output datasets
3. Datasets
4. Linked Services
   - Storage accounts, databases, other data sources.
5. Data Flows
6. Integration Runtimes

![The relationship between **data sets**, **activities**, and **pipelines**. [microsoft.com](https://learn.microsoft.com/en-us/azure/data-factory/concepts-pipelines-activities?tabs=data-factory)](/images/azure/datafactorycomps.png)

# Weird ADF Limitations

As this technology is built on a foundation of other technologies
(Synapse, Spark, etc) there are a handful of strange limitations that
must be considered when applying a data factory in your solution
architectures.

- The **Lookup Activity** supports a max of 5000 rows or 4mb of data
  returned
- The **GetMetaData Activity** supports a max of 5000 items of 4mb of
  data returned
- The **ForEach Activity** supports a max of 100,000 output items
- You can't nest **ForEach** activities
- Errors quite often don't mean what they say:
  - Carefully investigate and list the limitations of your sources and sinks
  - Perform a lot of initial testing to validate your choices in technology
  - **Many Azure systems and tools have shocking and strange limitations**
  - The only thing you can do is perform a large volume of research -
    describe your use cases to LLMs and read lots of documentation, as
    there are too many small limits for even a seasoned subject matter
    expert to recall at once.
- Default timeouts are set to 12h, absurdly high for most activities

# Pro Tips

Lessons learned when building and deploying data factory pipelines.

1. When designing tables for your environments, do not append `_dev`
   or `_v4` to your table names, stored procedures, or anything else.
   When copying your templates to production all these small strings
   will need to be corrected.
2. Make good use of **stored procedures** to track and trace the data
   processing and movement within your pipeline. This adds to the
   transparency of what has been completed if a pipeline fails.
3. The **default timeouts** are usually way too high. Aim to stall for
   a maximum of ten minutes (beyond typical execution time) before
   failure, and repeat only a few times.
4. When viewing a list of pipeline runs
5. **Expect to have failures** in production when first testing
   pipelines at scale due to throughput limits on some Azure
   resources - databases, storage accounts, etc.

**If you are ever typing 'dev', STOP AND THINK.** If your pipelines
will be moved between environments, use **Global Parameters** to hold
things like table schemas, blob container names, or other
environment-specific variables. *The only good place to type DEV is in
your **linked services** definitions or global variables.*

# Deployment

- [CI/CD in Azure Data Factory](https://learn.microsoft.com/en-us/azure/data-factory/continuous-integration-delivery)

# Data Movement (Copy) Activity

The [Copy Activity](https://learn.microsoft.com/en-us/azure/data-factory/copy-activity-overview)
is great for moving massive amounts of data from a souce to a
destination with zero transformation and minor filtering on dates. Using it
outside of this very specific use case will result in high costs
and is generally better to implement with an external system.

- You can perform additional actions with [rows which could not be copied](https://learn.microsoft.com/en-us/azure/data-factory/copy-activity-fault-tolerance#monitor-skipped-rows)
  due to errors.
- **Insight:** With *file path type* **"list of files"** you can
  provide a list of files with full paths in the filesystem to copy,
  but **cannot provide a destination path.** What insane tooling. The [docs](https://learn.microsoft.com/en-us/azure/data-factory/connector-azure-blob-storage?tabs=data-factory#file-list-examples)
  for this are very disappointing.
- "Flatten hierarchy" will give your files weird, long names. Use "preserve hierarchy".

Sources/sinks are [too numerous to
list](https://learn.microsoft.com/en-us/azure/data-factory/concepts-pipelines-activities?tabs=data-factory#data-movement-activities),
but the key ones I know how to use are as follows:

- [Blob storage](https://learn.microsoft.com/en-us/azure/data-factory/connector-azure-blob-storage)
- [Data Lake Gen 2](https://learn.microsoft.com/en-us/azure/data-factory/connector-azure-data-lake-storage)
- [Azure Files](https://learn.microsoft.com/en-us/azure/data-factory/connector-azure-file-storage)
- [Azure SQL](https://learn.microsoft.com/en-us/azure/data-factory/connector-azure-sql-database)
- [Azure Table Storage](https://learn.microsoft.com/en-us/azure/data-factory/connector-azure-table-storage)
- [PostgreSQL](https://learn.microsoft.com/en-us/azure/data-factory/connector-postgresql)
- [SQL Server](https://learn.microsoft.com/en-us/azure/data-factory/connector-sql-server)
- [Snowflake](https://learn.microsoft.com/en-us/azure/data-factory/connector-snowflake)
- [Amazon S3](https://learn.microsoft.com/en-us/azure/data-factory/connector-amazon-simple-storage-service)

# Control Flow Activities

Here is the full list taken and modified from [these docs](https://learn.microsoft.com/en-us/azure/data-factory/concepts-pipelines-activities?tabs=data-factory#data-movement-activities).

- **[Append Variable](https://learn.microsoft.com/en-us/azure/data-factory/control-flow-append-variable-activity)**: Add a value to an existing array variable.
- **[Execute Pipeline](https://learn.microsoft.com/en-us/azure/data-factory/control-flow-execute-pipeline-activity)**: Execute Pipeline activity allows a Data Factory or Synapse pipeline to invoke another pipeline.
- **[Filter](https://learn.microsoft.com/en-us/azure/data-factory/control-flow-filter-activity)**: Apply a filter expression to an input array
- **[For Each](https://learn.microsoft.com/en-us/azure/data-factory/control-flow-for-each-activity)**: ForEach Activity defines a repeating control flow in your pipeline. This activity is used to iterate over a collection and executes specified activities in a loop. The loop implementation of this activity is similar to the Foreach looping structure in programming languages.
- **[Get Metadata](https://learn.microsoft.com/en-us/azure/data-factory/control-flow-get-metadata-activity)**: GetMetadata activity can be used to retrieve metadata of any data in a Data Factory or Synapse pipeline.
- **[If Condition Activity](https://learn.microsoft.com/en-us/azure/data-factory/control-flow-if-condition-activity)**: The If Condition can be used to branch based on condition that evaluates to true or false. The If Condition activity provides the same functionality that an if statement provides in programming languages. It evaluates a set of activities when the condition evaluates to `true` and another set of activities when the condition evaluates to `false.`
- **[Lookup Activity](https://learn.microsoft.com/en-us/azure/data-factory/control-flow-lookup-activity)**: Lookup Activity can be used to read or look up a record/ table name/ value from any external source. This output can further be referenced by succeeding activities.
- **[Set Variable](https://learn.microsoft.com/en-us/azure/data-factory/control-flow-set-variable-activity)**: Set the value of an existing variable.
- **[Until Activity](https://learn.microsoft.com/en-us/azure/data-factory/control-flow-until-activity)**: Implements Do-Until loop that is similar to Do-Until looping structure in programming languages. It executes a set of activities in a loop until the condition associated with the activity evaluates to true. You can specify a timeout value for the until activity.
- **[Validation Activity](https://learn.microsoft.com/en-us/azure/data-factory/control-flow-validation-activity)**: Ensure a pipeline only continues execution if a reference dataset exists, meets a specified criteria, or a timeout has been reached.
- **[Wait Activity](https://learn.microsoft.com/en-us/azure/data-factory/control-flow-wait-activity)**: When you use a Wait activity in a pipeline, the pipeline waits for the specified time before continuing with execution of subsequent activities.
- **[Web Activity](https://learn.microsoft.com/en-us/azure/data-factory/control-flow-web-activity)**: Web Activity can be used to call a custom REST endpoint from a pipeline. You can pass datasets and linked services to be consumed and accessed by the activity.
- **[Webhook Activity](https://learn.microsoft.com/en-us/azure/data-factory/control-flow-webhook-activity)**: Using the webhook activity, call an endpoint, and pass a callback URL. The pipeline run waits for the callback to be invoked before proceeding to the next activity.

## Execute Pipeline

The [Execute Pipeline Activity](https://learn.microsoft.com/en-us/azure/data-factory/control-flow-execute-pipeline-activity)
enables the launching of a new pipeline from an initial pipeline.
The master pipeline will execute a slave pipeline which

## Get Metadata

This is for checking filesystems and querying file metadata. There is
a specific `exists` output that [you can use](https://learn.microsoft.com/en-us/azure/data-factory/control-flow-get-metadata-activity#create-a-get-metadata-activity-with-ui).

## Lookup

- The **[Lookup Activity](https://learn.microsoft.com/en-us/azure/data-factory/control-flow-lookup-activity)**
enables the querying of data from a linked SQL service for further handling.
- Supports a max of **5000 rows** or **4mb of data**, whichever comes
  first. **How useless!** How **incredibly fucking useless!!!** How do
  they expect us to do big data with this shit?!
  - **Solution:** Perhaps use `ORDER BY ID` and `OFFSET` with `LIMIT`
    to do batches of 1000.
  - This may not be so bad as it can guarantee somewhat parallel
    execution of groups of up to 5000 items - meaning the maximum time
    a pipeline takes to run can be dramatically reduced **and** a
    predictable maximum completion time can be estimated.

## Switch

Just like a lisp `cond` or C `switch`.

## ForEach

- You can [execute in parallel](https://learn.microsoft.com/en-us/azure/data-factory/control-flow-for-each-activity#parallel-execution)
  with a maximum parallelism of ... 50? Default 20!? Sigh. The variable `batchCount` controls this, and
  `isSequential` must be set to `False` for this to work, which is the default.
- **Limitations:** (to fix any of these, use nested pipelines)
  1. **ForEach** has a maximum of 100,000 items
  2. You can't nest **ForEeach**
  3. You can't use SetVariable to manage global pipeline variables

## Script

I mostly use this for small SQL operations.

You may get the error "Argument {0} is null or empty" if your return values do not

# Data Transformation Activities

Here is a subset taken directly from [these docs](https://learn.microsoft.com/en-us/azure/data-factory/concepts-pipelines-activities?tabs=data-factory#data-movement-activities).

- **[Data Flow](https://learn.microsoft.com/en-us/azure/data-factory/control-flow-execute-data-flow-activity)**: Apache Spark clusters managed by Azure Data Factory
- **[Azure Function](https://learn.microsoft.com/en-us/azure/data-factory/control-flow-azure-function-activity)**: Azure Functions
- **[MapReduce](https://learn.microsoft.com/en-us/azure/data-factory/transform-data-using-hadoop-map-reduce)**: HDInsight [Hadoop]
- **[Spark](https://learn.microsoft.com/en-us/azure/data-factory/transform-data-using-spark)**: HDInsight [Hadoop]
- **[Stored Procedure](https://learn.microsoft.com/en-us/azure/data-factory/transform-data-using-stored-procedure)**: Azure SQL, Azure Synapse Analytics, or SQL Server
- **[U-SQL](https://learn.microsoft.com/en-us/azure/data-factory/transform-data-using-data-lake-analytics)**: Azure Data Lake Analytics
- **[Custom Activity](https://learn.microsoft.com/en-us/azure/data-factory/transform-data-using-dotnet-custom-activity)**: Azure Batch
- **[Databricks Notebook](https://learn.microsoft.com/en-us/azure/data-factory/transform-data-databricks-notebook)**: Azure Databricks
- **[Databricks Jar Activity](https://learn.microsoft.com/en-us/azure/data-factory/transform-data-databricks-jar)**: Azure Databricks
- **[Databricks Python Activity](https://learn.microsoft.com/en-us/azure/data-factory/transform-data-databricks-python)**: Azure Databricks
- **[Synapse Notebook Activity](https://learn.microsoft.com/en-us/azure/synapse-analytics/synapse-notebook-activity)**: Azure Synapse Analytics

# Making Up for Missing Features

## Cartesian Product

Let's say you had two arrays:

```py
["Bob", "Bill", "Joe"]
[189, 873, 291]
```

There is literally no way in Azure Data Factory to produce a
*cartesian product* with the data above within a single pipeline. It
must be sent to an external activity - a data flow, function, or set
of pipelines. Here I used an Azure SQL server stored procedure to do
the 'heavy lifting' and passed the two arrays to the procedure as JSON
encoded in strings.

```sql
CREATE PROCEDURE [abcd].[pr_get_global_cartesian_product]
  @JsonArrayA NVARCHAR(MAX),
  @JsonArrayB NVARCHAR(MAX)
AS
BEGIN
  SET NOCOUNT ON;

  DECLARE @A TABLE (val1 NVARCHAR(100));
  DECLARE @B TABLE (val2 NVARCHAR(100));

  IF ISJSON(@JsonArrayA) = 0 OR ISJSON(@JsonArrayB) = 0
  BEGIN
    RAISERROR('One or both input parameters are not valid JSON arrays.', 16, 1);
    RETURN;
  END;

  -- Parse the JSON arrays into table variables
  INSERT INTO @A (val1)
  SELECT value FROM OPENJSON(@JsonArrayA);

  INSERT INTO @B (val2)
  SELECT value FROM OPENJSON(@JsonArrayB);

  -- Return the Cartesian product
  SELECT a.val1 as Site, b.val2 as Extraction
  FROM @A a
  CROSS JOIN @B b
  ORDER BY a.val1;
END;

-- Example execution:
EXECUTE [olr2].[pr_get_global_cartesian_product]
  @JsonArrayA = '["Bob", "Bill", "Joe"]',
  @JsonArrayB = '["189", "873", "291"]';
```

# CI/CD

- [Data Factory CI/CD](https://learn.microsoft.com/en-us/azure/data-factory/continuous-integration-delivery)
- [What is Azure Pipelines?](https://learn.microsoft.com/en-us/azure/devops/pipelines/get-started/what-is-azure-pipelines?view=azure-devops)
- [ADF CI/CD Best Practices](https://learn.microsoft.com/en-us/azure/data-factory/continuous-integration-delivery#best-practices-for-cicd)

# Monitoring, Azure Alerts, Emails

- You can [send emails](https://learn.microsoft.com/en-us/azure/data-factory/how-to-send-email) to
  notify of pipeline successes and failures.


# It's Microsoft, Beware

**Here Be Dragons:** As with any *Microsoft* product, there are many
bizarre and strange side effects and bugs that will interrupt your
workday and make you want to slam your keyboard over your knee. You
will be doomed to ceaselessly stumble into nonsensical undocumented
semi-automatic footguns at an alarming rate. Support will gaslight you
into thinking you are the problem until you provide incontrovertible
evidence that another band-aid must be stuck on their product entirely
made from popsicle sticks, band-aids, and white glue (plus great open
source projects somewhere in that mix.)

- Rename a file in Azure Data Studio? Lose the contents of the related
buffer and those crucial queries you had written. *Go rewrite them and
cry.*
- Close your browser window? *Go rewrite those pipelines and cry.*
- [Product Name] crashes? *Go rewrite your work and cry.*
- Thought you could run that external thing? *No. Barely documented
  timeout.[^1] Redesign your thing and go cry about it.*

This doesn't even get in to the seemingly thousands of strange legacy
limitations inherent in the Microsoft ecosystem. It's tough to know
about all of them, even as a subject matter expert. **Skim all the
docs you can ahead of time** to learn about as many of the limitations
as possible during your design phase.

*"Go rewrite it and cry"* really should be the byline of most
*Microsoft* cloud editing software. Triply check your work is saved
before every action, or it will be lost before you know it. As an
adult, *to cry* is really to *loudly shout curses at the ceiling and
stare miserably at your keyboard*, but that's a little long to type
three times. **Save your stuff.** **OR ELSE.**

[^1]: "Azure Function activity in Azure Data Factory: Timeout and long-running functions" [microsoft.com](https://learn.microsoft.com/en-us/azure/data-factory/control-flow-azure-function-activity#timeout-and-long-running-functions)
