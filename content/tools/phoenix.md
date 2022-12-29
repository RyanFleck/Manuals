---
toc: true
date: 2022-12-09T16:20:00.000-07:00
image: "/content-cover-images/coffee-phone.jpg"
summary: Phoenix, the Elixir Web Framework
title: Phoenix
---

# What is Phoenix?

Phoenix is a web application framework. Like Python's _Django_ or Ruby's _Rails_, Elixir has found _Phoenix_ to be the premier tool for web development. Elixir has some distinct advantages over these other languages.

[See all of my Elixir notes in the **Elixir Manual**.]({{< ref "/languages/elixir.md" >}})
It would be good to read the _Elixir_ manual first if you are not familiar with the language,
as it explains why the language is so special, along with how to consider problems with the
constraints provided by the functional language.

**There are weird things about Phoenix that you need to understand in order to understand the framework.** These things are marked with the symbol **(MAGIC)**.

**There are other weird things about Phoenix that you need to understand that make the framework clearer and easier to modify.** These things are marked with the symbol **(ANTI-MAGIC)**.

The creator of Phoenix is an individual named **Chris McCord**. Currently he works at **Fly.io**, and it would be good before starting to read this article that touches on the [history of Phoenix and LiveView](https://fly.io/blog/how-we-got-to-liveview/).

# Phoenix 1.2: Installation

The instructor suggests using **Phoenix 1.2**
Ensure you are checking the docs for this specific version on the Phoenix [hexdocs.pm/phoenix/1.2.5/](https://hexdocs.pm/phoenix/1.2.5/Phoenix.html)

Phoenix 1.2 is **old** (2017!) so we'll need to prep a time machine. See [this article I wrote](https://ryanfleck.ca/2022/phoenix-125-on-windows/)
and
[this forum post](https://elixirforum.com/t/setting-up-an-elixir-environment-for-phoenix-1-2-development)
to see how I figured this out.
The instructions here are for Windows 10.

0. Install Erlang 20.3
1. Install Elixir 1.5.3
2. Install NodeJS 8.11.3
3. Install Phoenix
4. Use Docker to spin up a Postgres 9 container

```sh
choco install erlang --version=20.3
choco install elixir --version=1.5.3
nvm install 8.11.3
nvm use 8.11.3
npm i -g brunch@2  # forcing brunch 2 fixes build errors

# This is all one line, reload your shell first
mix archive.install
  https://github.com/phoenixframework/archives/raw/master/phoenix_new.ez
```

Spin up a Postgres 9 container in Docker.

```
docker run --name phoenix-125-db -p 5432:5432
  -e POSTGRES_PASSWORD=<pwd> -d postgres:9
```

Finally, run `ecto create` and enjoy your new Phoenix project.

# Bootcamp Project III Creation Logs

**You should probably skip this section.**

If you've followed the setup steps above, you should be able to run `phoenix.new` without issues. I've included this as reference in case I run into a problem in the future and it's due to some deprecated library that was warned about here.

```
PS C:\Users\Developer\Documents\Elixir\discuss> elixir -v
Erlang/OTP 20 [erts-9.3] [64-bit] [smp:8:8] [ds:8:8:10] [async-threads:10]

Elixir 1.5.3

PS C:\Users\Developer\Documents\Elixir> mix phoenix.new discuss
* creating discuss/config/config.exs
* creating discuss/config/dev.exs
* creating discuss/config/prod.exs
  ... lots more files ...
* creating discuss/web/views/layout_view.ex
* creating discuss/web/views/page_view.ex

Fetch and install dependencies? [Yn] Y
* running mix deps.get
* running npm install && node node_modules/brunch/bin/brunch build

We are all set! Run your Phoenix application:

    $ cd discuss
    $ mix phoenix.server

You can also run your app inside IEx (Interactive Elixir) as:

    $ iex -S mix phoenix.server

Before moving on, configure your database in config/dev.exs and run:

    $ mix ecto.create
```

Open **mix.exs** and remove `:gettext` from the compilers list.

If your database is up and running, initialize the db.

```
PS C:\Users\Developer\Documents\Elixir> mix ecto.create
** (Mix) The task "ecto.create" could not be found
PS C:\Users\Developer\Documents\Elixir> cd discuss
PS C:\Users\Developer\Documents\Elixir\discuss> code .
PS C:\Users\Developer\Documents\Elixir\discuss> mix ecto.create
==> file_system
Compiling 7 files (.ex)
Generated file_system app
==> connection
Compiling 1 file (.ex)
Generated connection app
==> gettext
warning: the dependency :gettext requires Elixir "~> 1.11"
  but you are running on v1.5.3
Compiling 1 file (.yrl)
Compiling 1 file (.erl)
Compiling 21 files (.ex)
warning: function Kernel.ParallelCompiler.async/1 is
 undefined or private
  lib/gettext/compiler.ex:430

Generated gettext app
===> Compiling ranch
===> Compiling poolboy
==> decimal
Compiling 4 files (.ex)
Generated decimal app
warning: String.strip/1 is deprecated, use String.trim/1
  c:/Users/Developer/Documents/Elixir/discuss/deps/poison/mix.exs:4

==> poison
Compiling 4 files (.ex)
warning: Integer.to_char_list/2 is deprecated, use Integer.to_charlist/2
  lib/poison/encoder.ex:161

warning: HashDict.size/1 is deprecated, use maps and the Map module instead
  lib/poison/encoder.ex:283

Generated poison app
==> db_connection
Compiling 23 files (.ex)
Generated db_connection app
Compiling 13 files (.ex)
Generated phoenix_pubsub app
===> Compiling cowlib
src/cow_multipart.erl:392: Warning: call to
  crypto:rand_bytes/1 will fail, since it was removed
    in 20.0; use crypto:strong_rand_bytes/1

===> Compiling cowboy
==> mime
Compiling 2 files (.ex)
Generated mime app
==> plug
Compiling 44 files (.ex)
warning: Atom.to_char_list/1 is deprecated, use Atom.to_charlist/1
  lib/plug/builder.ex:186

warning: Kernel.to_char_list/1 is deprecated, use Kernel.to_charlist/1
  lib/plug/adapters/cowboy.ex:220

warning: Kernel.to_char_list/1 is deprecated, use Kernel.to_charlist/1
  lib/plug/adapters/cowboy.ex:238

warning: String.rstrip/1 is deprecated, use String.trim_trailing/1
  lib/plug/templates/debugger.html.eex:635

Generated plug app
==> phoenix_html
Compiling 8 files (.ex)
Generated phoenix_html app
==> phoenix
Compiling 60 files (.ex)
warning: String.lstrip/2 is deprecated, use
  String.trim_leading/2 with a binary as second argument
  lib/phoenix/template.ex:376

warning: String.strip/1 is deprecated, use String.trim/1
  lib/phoenix/code_reloader.ex:169

warning: String.rjust/2 is deprecated, use String.pad_leading/2
  lib/phoenix/router/console_formatter.ex:34

warning: String.ljust/2 is deprecated, use String.pad_trailing/2
  lib/phoenix/router/console_formatter.ex:35

warning: String.ljust/2 is deprecated, use String.pad_trailing/2
  lib/phoenix/router/console_formatter.ex:36

warning: String.strip/1 is deprecated, use String.trim/1
  lib/phoenix/router/helpers.ex:269

Generated phoenix app
==> phoenix_live_reload
Compiling 4 files (.ex)
Generated phoenix_live_reload app
==> postgrex
Compiling 62 files (.ex)
Generated postgrex app
==> ecto
Compiling 70 files (.ex)
Generated ecto app
==> phoenix_ecto
Compiling 6 files (.ex)
Generated phoenix_ecto app
==> discuss
Compiling 12 files (.ex)
Generated discuss app
The database for Discuss.Repo has been created
```

Given all this completed without error, start your local server and gaze upon a Phoenix 1.2 project template!

```
PS C:\Users\Developer\Documents\Elixir\discuss> mix phoenix.server
[info] Running Discuss.Endpoint with Cowboy using http://localhost:4000
16:56:32 - info: compiled 6 files into 2 files, copied 3 in 1.1 sec
[info] GET /
[debug] Processing by Discuss.PageController.index/2
  Parameters: %{}
  Pipelines: [:browser]
[info] Sent 200 in 47ms
```

...now we can start learning Phoenix in earnest.

This training material is very engaging; hopefully Phoenix 1.2 is similar enough to the current 1.5 that the lessons will carry over.

# Phoenix 1.2: EEX Templates and MVC

Unlike modern SPA + API configurations, Phoenix is monolithic.
Unlike older server-side templates, Phoenix does not send a brand new HTML page to the user each time a large action is taken.
Phoenix is a hybrid that combines the best of SPAs and the best of SSR.

This section deals with the `web/templates` folder.

The **layout** subfolder holds `app.html.eex` which contains the base for all HTML pages within the application.

At this point it might be smart to install the [Phoenix Framework](https://marketplace.visualstudio.com/items?itemName=phoenixframework.phoenix) VSCode extension and follow the instructions to add emmet support for eex files.

EEX templates work like HTML for the most part, but have plenty of special extra syntax to work with the backend.

**MVC typically works like this:**

0. **Model**: shape of the raw data in the database
1. **View**: organizes and displays the model data
2. **Controller**: manages the other two and state data

Phoenix 1.2 starts off with an empty models folder, a couple views, one template, and one controller. Oh, right, these additional components are also needed:

0. **Templates**: used by views to render pages
1. **Routers**: directs users to indicated pages

Our Phoenix app starts with one router. Lines 16-20 read:

```ex
scope "/", Discuss do
  pipe_through :browser # Use the default browser stack

  get "/", PageController, :index
end
```

**What does this do?** The router will take an incoming request, look through the rules, and pick the matching path. Here, when someone makes a **get** request to the root (`/`) it will find the module called **PageController** and run the `:index` function on it. That controller looks like this:

```ex
defmodule Discuss.PageController do
  use Discuss.Web, :controller

  def index(conn, _params) do
    render conn, "index.html"
  end
end
```

The request lifecycle at a high level (request data is passed down through these like a function chain) is something like:

- **Router** handles an incoming request
- **Controller** grabs model data from the database
- **View** renders a template and sends a response

**(MAGIC)** **Views and Templates are related by name.** A view named 'PageView' will rely on a subfolder in the templates folder called 'page'.
Every file in the corresponding folder will be added as functions to the view when Phoenix boots. Models and Controllers are also related by name.

In Django, this all has to be done manually and is boilerplate work. The invisible magic here saves time, but is important to note.

**Follow the naming conventions.**

# Phoenix 1.2 & IEX Interactive Shell

Phoenix can be opened in IEX for live debugging and running of functions currently in the works. Phoenix already live reloads, so the shell is moreso useful for debugging than general development.

```
PS C:\Users\Developer\Documents\Elixir\discuss> iex.bat -S mix phoenix.server
[info] Running Discuss.Endpoint with Cowboy using http://localhost:4000
Interactive Elixir (1.5.3) - press Ctrl+C to exit (type h() ENTER for help)

iex(1)> 19:34:00 - info: compiled 6 files into 2 files, copied 3 in 972 ms
iex(1)> [info] GET /
iex(1)> [debug] Processing by Discuss.PageController.index/2
  Parameters: %{}
  Pipelines: [:browser]
iex(1)> [info] Sent 200 in 47ms

iex(2)> Discuss.PageView.render("index.html")
{:safe,
 [[["" | "<div>\n  <h2>"] | "Welcome to Kektronics Supernova"] |
  "</h2>\n</div>\n"]}
```

# Phoenix 1.2: Model Essentials

Phoenix has a typical model and migration system. You can generate migration files from the command line:

```
> mix ecto.gen.migration add_topics
* creating priv/repo/migrations
* creating priv/repo/migrations/20221213030625_add_topics.exs
```

Migrations are datestamped on the filename so they run in the correct order when a database is being updated.

Opening this new migration file reveals almost nothing:

```ex
defmodule Discuss.Repo.Migrations.AddTopics do
  use Ecto.Migration

  def change do

  end
end
```

Add this in `change`:

```ex
    create table(:topics) do
      add :title, :string
    end
```

...and that'll make a simple table of topics with an id and a column called `:title` of type `:string`. Now we can run the migration to create the tables in the connected database:

```
> mix ecto.migrate
[info] == Running Discuss.Repo.Migrations.AddTopics.change/0 forward
[info] create table topics
[info] == Migrated in 0.0s
```

If you'd like to confirm this worked, login to your postgres instance and run:

```sql
select * from topics;
```

# Phoenix 1.2: A Complete MVC Page

Let's show a form to a user and save some data to our database.

We need to:

1. Add a route in our router file to direct the user to the new page.
2. Add a controller method to handle this request.
3. Make a new template to show the form to the user.
4. Create a topic model that can hold all the data in the form.
5. Make a new controller and view to manage things related to 'topics'.

## Add Route

Add this to your `Discuss.Router` under the line for the index:

```ex
get "/topics/new", TopicController, :new
```

...like before, this format dictates that when a user goes to the path indicated, Phoenix will give the request to the `new` function on the `TopicController`.

Here are some conventional routes and their corresponding controller functions:

- `:new` - `GET /topics/new`
- `:create` - `POST /topics`
- `:index` - `GET /topics`
- `:delete` - `DELETE /topics/12`
- `:edit` - `GET /topics/12/edit`
- `:update` - `PUT /topics/12`

...since this isn't an API, some of these may seem a bit unusual to PWA + API builders, as it is a mix of pages and API actions -- though all of the GET requests will return pages for the above conventions.

At this point the instructor has stressed that **Phoenix will work well for you if you follow these conventions.**

## Add Controller

Create a new file called `web/controllers/topic_controller.ex`

**Always use the singular form of the noun when naming things.**

```ex
defmodule Discuss.TopicController do
  use Discuss.Web, :controller   # <== What's this?

  def new() do

  end
end
```

These keywords are used to pull additional functionality into modules.

- `import` -- copy all the functions to the current module
- `alias` -- make a shortcut to a module, functions become available as if they were within the module, but are not available to call by using the module
- `use` -- like import, but with fancy setup, it's complicated

[=> elixir-lang.org: alias, require, and import](https://elixir-lang.org/getting-started/alias-require-and-import.html)

If we check `page_controller.ex` we can see:

```ex
defmodule Discuss.PageController do
  use Discuss.Web, :controller

  def index(conn, _params) do
    render conn, "index.html"
  end
end
```

If we check `web.ex` we can see:

```ex
def controller do
  quote do
    use Phoenix.Controller

    alias Discuss.Repo
    import Ecto
    import Ecto.Query

    import Discuss.Router.Helpers
    import Discuss.Gettext
  end
end
```

Looks like we need to steal the `use` definition from the other controller so we can also give our module the properties and functions of a controller.

...what's `quote do`?

**Aw shit -- we just got our first taste of metaprogramming.**

> Quote and Unquote: This guide aims to introduce the meta-programming techniques available in Elixir. The ability to represent an Elixir program by its own data structures is at the heart of meta-programming.  
> -- **[elixir-lang.org](https://elixir-lang.org/getting-started/meta/quote-and-unquote.html)**

...so I guess **use** must apply the quoted operations. Slick.

Add `conn` and `params` to our new function in our Topic controller:

```ex
defmodule Discuss.TopicController do
  use Discuss.Web, :controller

  def new(conn, _params) do
    IO.puts "+++++"
    IO.inspect conn  # pretty print the data structure
  end
end
```

By logging the `conn` parameter we can see a `Plug.Conn` struct that is passed to us at this point in the Phoenix function pipeline. Some bits are shortened/redacted but I've left it mostly intact.

(**(ANTI-MAGIC)** The exposure of the definitions for model, view, controller, router, and channel in `web.ex` means it is easy to write shared behavior for all your functions. Hiding these definitions within the framework would have prevented that.)

This `Conn` struct is the center of Phoenix.

```
%Plug.Conn{adapter: {Plug.Adapters.Cowboy.Conn, :...}, assigns: %{},
 before_send: [#Function<0.7415431/1 in Plug.CSRFProtection.call/2>,
  #Function<4.18464706/1 in Phoenix.Controller.fetch_flash/2>,
  #Function<0.112984571/1 in Plug.Session.before_send/2>,
  #Function<1.120023888/1 in Plug.Logger.call/2>,
  #Function<0.34983904/1 in Phoenix.LiveReloader.before_send_inject_reloader/2>],
 body_params: %{},
 cookies: %{
   "_hello_key" => " ( hidden ) ",
   "csrftoken" => " ( hidden ) ",
   "messages" => "  ( hidden ) "},
 halted: false, host: "localhost", method: "GET", owner: #PID<0.598.0>,
 params: %{}, path_info: ["topics", "new"], path_params: %{},
 peer: {{127, 0, 0, 1}, 63690}, port: 4000,
 private: %{Discuss.Router => {[], %{}}, :phoenix_action => :new,
   :phoenix_controller => Discuss.TopicController,
   :phoenix_endpoint => Discuss.Endpoint, :phoenix_flash => %{},
   :phoenix_format => "html", :phoenix_layout => {Discuss.LayoutView, :app},
   :phoenix_pipelines => [:browser],
   :phoenix_route => #Function<1.51542571/1 in Discuss.Router.match_route/4>,
   :phoenix_router => Discuss.Router, :phoenix_view => Discuss.TopicView,
   :plug_session => %{}, :plug_session_fetch => :done}, query_params: %{},
 query_string: "", remote_ip: {127, 0, 0, 1},
 req_cookies: %{
   "_hello_key" => " ( hidden ) ",
   "csrftoken" => " ( hidden ) ",
   "messages" => "  ( hidden ) "},
 req_headers: [{"host", "localhost:4000"}, {"connection", "keep-alive"},
  {"cache-control", "max-age=0"}, {"upgrade-insecure-requests", "1"},
  {"user-agent",
   "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36"},
  {"accept",
   "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8"},
  {"sec-gpc", "1"}, {"sec-fetch-site", "same-origin"},
  {"sec-fetch-mode", "navigate"}, {"sec-fetch-user", "?1"},
  {"sec-fetch-dest", "document"},
  {"referer", "http://localhost:4000/topics/new"},
  {"accept-encoding", "gzip, deflate, br"},
  {"accept-language", "en-US,en;q=0.9"},
 request_path: "/topics/new", resp_body: nil, resp_cookies: %{},
 resp_headers: [{"cache-control", "max-age=0, private, must-revalidate"},
  {"x-request-id", "ddks9ld8b768m8mbfqjgnnp6grtv8eq7"},
  {"x-frame-options", "SAMEORIGIN"}, {"x-xss-protection", "1; mode=block"},
  {"x-content-type-options", "nosniff"}], scheme: :http, script_name: [],
 secret_key_base: " ( hidden ) ",
 state: :unset, status: nil}
```

The `params` arg looks like this:

```
[debug] Processing by Discuss.TopicController.new/2
  Parameters: %{}
  Pipelines: [:browser]
%{}
```

## Add Model

Here we'll add a model with a changeset and validations.

Create `models/topic.ex` with:

1. The model **schema**.
2. A **changeset** function.

```ex
defmodule Discuss.Topic do
  use Discuss.Web, :model

  # Step 1
  schema "topics" do
    field :title, :string
  end

  # Step 2
  def changeset(struct, params \\ %{}) do
    struct
    |> cast(params, [:title])
    |> validate_required([:title])
  end

end
```

The instructor says `changeset` structure is one of the
most challenging parts of Phoenix to understand and work with.

Rather than store a complete and mutated copy of an object being modified, Phoenix produces changesets.

**Important:** `//` is how you provide default arguments in Elixir. Above, an empty map is provided. Otherwise it will default to `nil`.

Update the `TopicController` to read:

```ex
defmodule Discuss.TopicController do
  use Discuss.Web, :controller
  alias Discuss.Topic

  def new(_conn, _params) do
    changeset = Topic.changeset(%Topic{}, %{})
    render conn, "new.html"  # (not created yet)
  end
end
```

## Add View & Template

1. Create `/web/views/topic_view.ex` and add:

```ex
defmodule Discuss.TopicView do
  use Discuss.Web, :view
end
```

2. Make a new directory `/web/templates/topic`
3. In this directory make `new.html.eex`

We can use Elixir code to make the form for us.

```ex
<%= form_for @changeset, topic_path(@conn, :create), fn f -> %>
<% end %>
```

...crap, what?

This is actually this elixir, with template syntax:

```ex
form_for(@changeset, topic_path(@conn, :create), fn f -> "" end)
```

The function `topic_path` will be explained later.

**Important:** Things prefixed here with `@` refer to variables passed to the template by the render function. Some variables are passed automatically.

Change the render line and add a bit more to the heex template:

```ex
    render conn, "new.html", changeset: changeset
```

````ex
<h3>New Topic</h3>
<%= form_for @changeset, topic_path(@conn, :create), fn f -> %>
    <div class="form-group">
        <%= text_input f, :title, placeholder: "Title", class: "form-control" %>
    </div>
    <%= submit "Save Topic", class: "btn btn-primary" %>
<% end %>```ex
<%= form_for @changeset, topic_path(@conn, :create), fn f -> %>

<% end %>
````

Next, copy this line to your router:

```ex
post "/topics", TopicController, :create
```

If you run `mix phoenix.routes` you'll see:

```
> mix phoenix.routes
 page_path  GET   /            Discuss.PageController :index
topic_path  GET   /topics/new  Discuss.TopicController :new
topic_path  POST  /topics      Discuss.TopicController :create
```

Note the term `topic_path` here. This path helper takes the first and last elements on this line to reduce errors when sending forms around.

Finally, let's start to finish the `create` method:

```ex
def create(conn, %{"topic" => topic}) do
  changeset = Topic.changeset(%Topic{}, topic)
  case Repo.insert(changeset) do
    {:ok, post} -> IO.inspect(post)
    {:error, err_changeset} -> IO.inspect(err_changeset)
  end
end
```

...this still throws an error, but we can see a record is inserted by logging the success and error messages:

```
[info] POST /topics
[debug] Processing by Discuss.TopicController.create/2
  Parameters: %{"_csrf_token" => " ( hidden ) ",
    "_utf8" => "Γ£ô",
    "topic" => %{"title" => "Test 2"}}
  Pipelines: [:browser]
[debug] QUERY OK db=0.0ms
INSERT INTO "topics" ("title") VALUES ($1) RETURNING "id" ["Test 2"]
%Discuss.Topic{__meta__: #Ecto.Schema.Metadata<:loaded, "topics">, id: 1,
 title: "Test 2"}
[info] Sent 500 in 109ms
```

We still want to redirect users to the topic list on success, or show validation errors and remain on the page in that case.

To render errors, add this to the EEX:

```ex
<%= error_tag f, :title %>
```

And update the controller:

```ex
def create(conn, %{"topic" => topic}) do
  changeset = Topic.changeset(%Topic{}, topic)
  case Repo.insert(changeset) do
    # X
    {:ok, post} -> IO.inspect(post)
    # Return the changeset with errors if they exist
    {:error, err_changeset} -> render conn, "new.html", changeset: err_changeset
  end
end
```

...the tutorial stops here and we are supposed to fill the success case in the next part of the tutorial, after we build the list view.

## Add Home/List Template & View

It's breaking RESTful conventions a bit, but we're going to route users who come to the site to the list of topics. Update your router:

```
get "/", TopicController, :index
```

...at this point you could delete the controller, view, and templates for _Page_.

[Ecto 2.0.5 Documentation](https://hexdocs.pm/ecto/2.0.5/Ecto.html)

Tutorial guy wants us to use [Repo.all](https://hexdocs.pm/ecto/2.0.5/Ecto.Repo.html#c:all/2) which cannot be a good long term solution but will be fine to prove a point.

```ex
def index(conn, _params) do
  # Render a list of all the topics in the database.
  # If unaliased, Discuss.Repo.all(Discuss.Topic)
  render conn, "index.html", topics: Repo.all(Topic)
end
```

Add a new template: `/templates/topic/index.html.eex`

```html
<h2>Topics</h2>
<ul class="collection">
  <!-- Let's iterate through the *topics* list -->
  <%= for topic <- @topics do %>
  <li class="collection-item"><%= topic.title %></li>
  <% end %>
</ul>
```

...works good!

**Let's finish our `/topics/new` page.**

## Link the Pages

Redirect to index after topic creation:

```ex
def create(conn, %{"topic" => topic}) do
  changeset = Topic.changeset(%Topic{}, topic)
  case Repo.insert(changeset) do
    {:ok, post} ->
      conn
      |> put_flash(:info, "Topic Created")
      |> redirect(to: topic_path(conn, :index))
    {:error, err_changeset} ->
      render conn, "new.html", changeset: err_changeset
  end
end
```

The `put_flash` function allows us to show one-time messages to our user, like "topic created". Now the user will be redirected to the home page with a flash message after they submit a new topic.

(He adds some new stuff to `app.html.eex`)

```html
<!-- Compiled and minified CSS -->
<link
  rel="stylesheet"
  href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css"
/>
<!-- Compiled and minified JavaScript -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
<!-- Compiled and minified JavaScript -->
<link
  rel="stylesheet"
  href="https://fonts.googleapis.com/icon?family=Material+Icons"
/>
```

At the bottom of `topic/index.html.eex` place this button with an elixir link/path reference:

```ex
<div class="fixed-action-btn">
    <%= link to: topic_path(@conn, :new),
      class: "btn-floating btn-large waves-effect waves-light red" do %>
        <i class="material-icons">add</i>
    <% end %>
</div>

```

...sweet, we're **all wired up!**

## Router Wildcards & Edit Page

What to do if we want to edit or update our records?

```ex
# Typically (For example: (conn, :edit, 12))
topic_path(connn, :action, id)

# In router
get "/topics/:id/edit", TopicController, :edit
#            :id -> this is a wildcard matcher
#                   and will show up in params

# In Topic Controller
# (Reminder that params keys are strings)
def edit(conn, %{"id" => topic_id}) do
  # Load an existing/complete 'changeset' from the database.
  topic = Repo.get(Topic, topic_id)
  changeset = Topic.changeset(topic)
  # Send it out, bound to a new template we'll make now
  render conn, "edit.html", changeset: changeset, topic: topic
end
```

...and write that template:

```ex
<h3>Edit Topic</h3>
<%= form_for @changeset, topic_path(@conn, :update, @topic), fn f -> %>
    <div class="form-group">
        <%= text_input f, :title, placeholder: "Title", class: "form-control" %>
        <p style="color: red">
        <%= error_tag f, :title %>
        </p>
    </div>
    <%= submit "Save Topic", class: "btn btn-primary" %>
<% end %>
```

...and write the controller for the update action:

```ex
def update(conn, %{"topic" => topic, "id" => id}) do
  # We fetch the original record from the repository first? Ok.
  old_topic = Repo.get(Topic, id)
  changeset = Topic.changeset(old_topic, topic)
  # Push the update to the database:
  case Repo.update(changeset) do
    {:ok, _topic} ->
      conn
      |> put_flash(:info, "Topic Updated")
      |> redirect(to: topic_path(conn, :index))
    {:error, err_changeset} ->
      render conn, "edit.html",
        changeset: err_changeset, topic: old_topic
  end
end
```

**This doesn't handle an id not found error.** Fine for now.

To add an edit button to your index type:

```html
<div class="right"><%= link "Edit", to: topic_path(@conn, :edit, topic) %></div>
```

Since we have followed RESTful conventions, we can actually use the `resources` tool to generate **all our routes** rather than adding a delete function at this point in the game:

```ex
scope "/", Discuss do
  pipe_through :browser # Use the default browser stack

  # get "/", TopicController, :index
  # get "/topics/new", TopicController, :new
  # post "/topics", TopicController, :create
  # get "/topics/:id/edit", TopicController, :edit
  # put "/topics/:id", TopicController, :update
  resources "/", TopicController
end
```

```
mix phoenix.routes
Compiling 8 files (.ex)
topic_path  GET     /          Discuss.TopicController :index
topic_path  GET     /:id/edit  Discuss.TopicController :edit
topic_path  GET     /new       Discuss.TopicController :new
topic_path  GET     /:id       Discuss.TopicController :show
topic_path  POST    /          Discuss.TopicController :create
topic_path  PATCH   /:id       Discuss.TopicController :update
            PUT     /:id       Discuss.TopicController :update
topic_path  DELETE  /:id       Discuss.TopicController :delete
```

...because we're using route helpers, we don't need to go back through our application to change all the paths for different actions.

**Do note that we haven't implemented `:show` or `:delete` yet.**

## Delete Button

```ex
def delete(conn, %{"id" => topic_id}) do
  Repo.get!(Topic, topic_id) |> Repo.delete!
end
```

The `topic_path` helper always sends a GET request so you must add an additional argument in your list view to ensure it sends a DELETE request.

```html
<div class="right">
  <%= link "Edit", to: topic_path(@conn, :edit, topic) %> <%= link "Delete", to:
  topic_path(@conn, :delete, topic), method: :delete %>
</div>
```

Adding that delete method specification means Phoenix will insert a full form at this point in the code to submit the DELETE request to the backend.

## Completed MVC Page

**-> web/controllers/topic_controller.ex**

```ex
defmodule Discuss.TopicController do
  use Discuss.Web, :controller
  alias Discuss.Topic

  def index(conn, _params) do
    # Render a list of all the topics in the database.
    # If unaliased, Discuss.Repo.all(Discuss.Topic)
    render conn, "index.html", topics: Repo.all(Topic)
  end

  def new(conn, _params) do
    changeset = Topic.changeset(%Topic{}, %{})
    render conn, "new.html", changeset: changeset
  end

  def create(conn, %{"topic" => topic}) do
    changeset = Topic.changeset(%Topic{}, topic)
    case Repo.insert(changeset) do
      {:ok, _post} ->
        conn
        |> put_flash(:info, "Topic Created")
        |> redirect(to: topic_path(conn, :index))
      {:error, err_changeset} -> render conn, "new.html", changeset: err_changeset
    end
  end

  def edit(conn, %{"id" => topic_id}) do
    # Load an existing/complete 'changeset' from the database.
    topic = Repo.get!(Topic, topic_id)
    changeset = Topic.changeset(topic)
    # Send it out, bound to a new template we'll make now
    render conn, "edit.html", changeset: changeset, topic: topic
  end

  def update(conn, %{"topic" => topic, "id" => id}) do
    # We fetch the original record from the repository first? Ok.
    old_topic = Repo.get!(Topic, id)
    changeset = Topic.changeset(old_topic, topic)
    # Push the update to the database:
    case Repo.update(changeset) do
      {:ok, _topic} ->
        conn
        |> put_flash(:info, "Topic Updated")
        |> redirect(to: topic_path(conn, :index))
      {:error, err_changeset} ->
        render conn, "edit.html",
          changeset: err_changeset, topic: old_topic
    end
  end

  def delete(conn, %{"id" => topic_id}) do
    Repo.get!(Topic, topic_id) |> Repo.delete!
    conn
    |> put_flash(:info, "Topic Deleted")
    |> redirect(to: topic_path(conn, :index))
  end
end
```

**-> web/models/topic.ex**

```ex
defmodule Discuss.Topic do
  use Discuss.Web, :model

  schema "topics" do
    field :title, :string
  end

  def changeset(struct, params \\ %{}) do
    struct
    |> cast(params, [:title])
    |> validate_required([:title])
  end
end
```

**-> priv/repo/migrations/20221213030625_add_topics.exs**

```ex
defmodule Discuss.Repo.Migrations.AddTopics do
  use Ecto.Migration

  def change do
    create table(:topics) do
      add :title, :string
    end
  end
end
```

**-> web/views/topic_view.ex**

```ex
defmodule Discuss.TopicView do
  use Discuss.Web, :view
end
```

**-> web/templates/index.html.eex**

```html
<h2>Topics</h2>

<ul class="collection">
  <!-- Let's iterate through the *topics* list -->
  <%= for topic <- @topics do %>
  <li class="collection-item">
    <%= topic.title %>
    <div class="right">
      <%= link "Edit", to: topic_path(@conn, :edit, topic) %> <%= link "Delete",
      to: topic_path(@conn, :delete, topic), method: :delete %>
    </div>
  </li>
  <% end %>
</ul>

<div class="fixed-action-btn">
  <%= link to: topic_path(@conn, :new), class: "btn-floating btn-large
  waves-effect waves-light red" do %>
  <i class="material-icons">add</i>
  <% end %>
</div>
```

**-> web/templates/edit.html.eex**

```html
<h3>Edit Topic</h3>
<%= form_for @changeset, topic_path(@conn, :update, @topic), fn f -> %>
<div class="form-group">
  <%= text_input f, :title, placeholder: "Title", class: "form-control" %>
  <p style="color: red"><%= error_tag f, :title %></p>
</div>
<%= submit "Save Topic", class: "btn btn-primary" %> <% end %>
```

**-> web/templates/new.html.eex**

```html
<h3>New Topic</h3>
<%= form_for @changeset, topic_path(@conn, :create), fn f -> %>
<div class="form-group">
  <%= text_input f, :title, placeholder: "Title", class: "form-control" %>
  <p style="color: red"><%= error_tag f, :title %></p>
</div>
<%= submit "Save Topic", class: "btn btn-primary" %> <% end %>
```

**-> web/router.ex**

```ex
defmodule Discuss.Router do
  use Discuss.Web, :router

  pipeline :browser do
    plug :accepts, ["html"]
    plug :fetch_session
    plug :fetch_flash
    plug :protect_from_forgery
    plug :put_secure_browser_headers
  end

  pipeline :api do
    plug :accepts, ["json"]
  end

  scope "/", Discuss do
    pipe_through :browser # Use the default browser stack

    # get "/", TopicController, :index
    # get "/topics/new", TopicController, :new
    # post "/topics", TopicController, :create
    # get "/topics/:id/edit", TopicController, :edit
    # put "/topics/:id", TopicController, :update
    resources "/", TopicController
  end

  # Other scopes may use custom stacks.
  # scope "/api", Discuss do
  #   pipe_through :api
  # end
end
```

# Phoenix 1.2: OAuth Authentication

Generally, the steps are:

1. The user clicks "login with X service" and is redirected
2. X service's website asks the user to login there
3. With a successful X login, the user is redirected back to our site
4. Our backend uses the provided code to fetch user details from service X if the user does not already exist in our system
5. The user is created or found and logged in

First, install `ueberauth` and the `ueberauth_github` authentication strategy.

Add the following lines to your deps and run `mix deps.get`.

```ex
{:ueberauth, "~> 0.3"},
{:ueberauth_github, "~> 0.4"},
```

Mix will install many packages.

```
New:
  ueberauth 0.5.0
  ueberauth_github 0.7.0
  certifi 2.9.0
  hackney 1.18.1
  idna 6.1.1
  metrics 1.0.1
  mimerl 1.2.0
  oauth2 0.9.4
  parse_trans 3.3.1
  ssl_verify_fun 1.1.6
  unicode_util_compat 0.7.0
```

...the latest `ueberauth` is `0.7` but mix chose to install `0.5`.

## Configure Ueberauth Library

At [github.com/settings/developers](https://github.com/settings/developers), register a new OAuth App:

```
Application name: Elixir-Discuss
Homepage URL: https://discuss.ryanfleck.ca
Application description: OAuth practice.
Auth callback URL: http://localhost:4000/auth/github/callback
```

In `mix.exs` add:

```ex
# Ensure ueberauth and ueberauth_github are in your apps
def application do
  [mod: {Discuss, []},
    applications: [:phoenix, :phoenix_pubsub, :phoenix_html,
      :cowboy, :logger, :gettext, :phoenix_ecto, :postgrex,
      :ueberauth, :ueberauth_github]]
end
```

In `config/config.exs`, add:

```ex
config :ueberauth, Ueberauth,
  providers: [
    github: { Ueberauth.Strategy.Github, []}
  ]

config :ueberauth, Ueberauth.Strategy.Github.OAuth,
  client_id: " < your client ID from Github > ",
  client_secret: " < your client secret from Github > "
```

We can worry about hiding the keys later.

Setup is done.

## Add OAuth Controller & Routes

Create `controllers/auth_controller.ex`.

```ex
defmodule Discuss.AuthController do
  use Discuss.Web, :controller
  plug Ueberauth
end
```

The topic of `plug` will be touched on later.

**Ueberauth assumes that you will write a `callback` function in your controller. Writing this function fulfills that contract.**

For now:

```ex
def callback(conn, params) do
  IO.puts "++++++++++++++++++"
  IO.inspect(conn.assigns)
  IO.puts "++++++++++++++++++"
  IO.inspect(params)
  IO.puts "++++++++++++++++++"
end
```

Let's add a new router for this controller:

```ex
scope "/auth", Discuss do
  pipe_through :browser

  # "Request" is defined automatically by Ueberauth
  # This functions the first step of the auth flow
  get "/:provider", AuthController, :request

  # Github/other provider will call this URL.
  get "/:provider/callback", AuthController, :callback

end
```

```
 auth_path  GET     /auth/:provider           Discuss.AuthController :request
 auth_path  GET     /auth/:provider/callback  Discuss.AuthController :callback
```

The login endpoint will now work up until the `callback` function.

I modified my login/auth endpoint to kick us back to the homescreen. Even though the authentication flow is technically 'complete' by doing this, the user is not logged in and has no account in our database. This is mostly for debugging.

```ex
defmodule Discuss.AuthController do
  use Discuss.Web, :controller
  plug Ueberauth

  def callback(conn, params) do
    IO.puts "++++++++++++++++++"
    IO.inspect(conn.assigns)
    IO.puts "++++++++++++++++++"
    IO.inspect(params)
    IO.puts "++++++++++++++++++"
    conn
    |> put_flash(:info, "Welcome back!")
    |> redirect(to: topic_path(conn, :index))
  end
end
```

Navigate to `/auth/github` and login to Github.

If we watch the logs, we'll see:

```
[info] GET /auth/github
[debug] Processing by Discuss.AuthController.request/2
  Parameters: %{"provider" => "github"}
  Pipelines: [:browser]
[info] Sent 302 in 0┬╡s
[debug] Discuss.AuthController halted in Ueberauth.call/2
[info] GET /auth/github/callback
[debug] Processing by Discuss.AuthController.callback/2
  Parameters: %{"code" => " < hidden > ", "provider" => "github"}
  Pipelines: [:browser]
++++++++++++++++++
%{ueberauth_auth: %Ueberauth.Auth{credentials: %Ueberauth.Auth.Credentials{expires: false,
    expires_at: nil, other: %{}, refresh_token: nil, scopes: [""], secret: nil,
    token: " < hidden > ", token_type: "Bearer"},
   extra: %Ueberauth.Auth.Extra{raw_info: %{token: %OAuth2.AccessToken{access_token: " < hidden > ",
       expires_at: nil, other_params: %{"scope" => ""}, refresh_token: nil,
       token_type: "Bearer"},
      user: %{"avatar_url" => "https://avatars.githubusercontent.com/u/28709508?v=4",
        "bio" => "Consultant @IBM", "blog" => "https://ryanfleck.ca",
        "company" => "IBM", "created_at" => "2017-05-15T14:34:41Z",
        "email" => "ryan.fleck@protonmail.com",
        "events_url" => "https://api.github.com/users/RyanFleck/events{/privacy}",
        "followers" => 41,
        "followers_url" => "https://api.github.com/users/RyanFleck/followers",
        "following" => 90,
        "following_url" => "https://api.github.com/users/RyanFleck/following{/other_user}",
        "gists_url" => "https://api.github.com/users/RyanFleck/gists{/gist_id}",
        "gravatar_id" => "", "hireable" => nil,
        "html_url" => "https://github.com/RyanFleck", "id" => 28709508,
        "location" => "Canada", "login" => "RyanFleck", "name" => "Ryan Fleck",
        "node_id" => " < hidden > ",
        "organizations_url" => "https://api.github.com/users/RyanFleck/orgs",
        "public_gists" => 21, "public_repos" => 81,
        "received_events_url" => "https://api.github.com/users/RyanFleck/received_events",
        "repos_url" => "https://api.github.com/users/RyanFleck/repos",
        "site_admin" => false,
        "starred_url" => "https://api.github.com/users/RyanFleck/starred{/owner}{/repo}",
        "subscriptions_url" => "https://api.github.com/users/RyanFleck/subscriptions",
        "twitter_username" => nil, "type" => "User",
        "updated_at" => "2022-12-15T04:04:20Z",
        "url" => "https://api.github.com/users/RyanFleck"}}},
   info: %Ueberauth.Auth.Info{description: "Consultant @IBM",
    email: "ryan.fleck@protonmail.com", first_name: nil,
    image: "https://avatars.githubusercontent.com/u/28709508?v=4",
    last_name: nil, location: "Canada", name: "Ryan Fleck",
    nickname: "RyanFleck", phone: nil,
    urls: %{api_url: "https://api.github.com/users/RyanFleck",
      avatar_url: "https://avatars.githubusercontent.com/u/28709508?v=4",
      blog: "https://ryanfleck.ca",
      events_url: "https://api.github.com/users/RyanFleck/events{/privacy}",
      followers_url: "https://api.github.com/users/RyanFleck/followers",
      following_url: "https://api.github.com/users/RyanFleck/following{/other_user}",
      gists_url: "https://api.github.com/users/RyanFleck/gists{/gist_id}",
      html_url: "https://github.com/RyanFleck",
      organizations_url: "https://api.github.com/users/RyanFleck/orgs",
      received_events_url: "https://api.github.com/users/RyanFleck/received_events",
      repos_url: "https://api.github.com/users/RyanFleck/repos",
      starred_url: "https://api.github.com/users/RyanFleck/starred{/owner}{/repo}",
      subscriptions_url: "https://api.github.com/users/RyanFleck/subscriptions"}},
   provider: :github, strategy: Ueberauth.Strategy.Github, uid: < hidden >}}
++++++++++++++++++
%{"code" => " < hidden > ", "provider" => "github"}
++++++++++++++++++
[info] Sent 302 in 625ms
[info] GET /
```

**Awesome.** That was easy.

...the first logged property here, `conn.assigns`, contains a bunch of data put there by ueberauth. This is also where **we** should stash additional data about the connection.

## User Table Migrations & Model

```
> mix ecto.gen.migration add_users
* creating priv/repo/migrations
* creating priv/repo/migrations/20221219181732_add_users.exs
```

Open `20221219181732_add_users.exs` and add:

```ex
defmodule Discuss.Repo.Migrations.AddUsers do
  use Ecto.Migration

  def change do
    create table(:users) do
      add :email, :string
      add :provider, :string
      add :token, :string

      # This adds created_at and last_modified fields
      timestamps()
    end
  end
end
```

Finally, migrate the changes.

```
> mix ecto.migrate
[info] == Running Discuss.Repo.Migrations.AddUsers.change/0 forward
[info] create table users
[info] == Migrated in 0.0s
```

Add a `user.ex` model and add the following:

```ex
defmodule Discuss.User do
  use Discuss.Web, :model

  # We ALWAYS need to define two things in a model:
  # 1. Schema, 2. Changeset

  schema "users" do
    field :email, :string
    field :provider, :string
    field :token, :string
    timestamps()
  end

  def changeset(struct, params \\ %{}) do
    # Cast the struct and params, then validate the fields
    struct
    |> cast(params, [:email, :provider, :token])
    |> validate_required([:email, :provider, :token])
  end

end
```

## Update the AuthController

We need to accesss some of the data pulled from `ueberauth` on the `conn.assigns` object to create or authenticate our user.

From the auth object, we want the user's token and email.

```ex
def callback(conn, params) do
  # Pull the 'auth' struct off the connection.
  %{assigns: %{ueberauth_auth: auth}} = conn
  user_params = %{
    token: auth.credentials.token,
    email: auth.info.email,
    provider: auth.provider
  }
  IO.puts "++++++++++++++++++"
  IO.inspect(user_params)
  IO.puts "++++++++++++++++++"
  conn
  |> put_flash(:info, "Welcome back!")
  |> redirect(to: topic_path(conn, :index))
end
```

```
%{email: "ryan.fleck@protonmail.com", provider: :github,
  token: "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"}
```

Next, prepare the changeset:

```ex
# In the module, just type 'User' instead of 'Discuss.User'
alias Discuss.User

  # Make our changeset:
  changeset = User.changeset(%User{}, user_params)
```

Define a **private function** with **defp**!

(**ASIDE**) _I think if I were to build an application, it would use a variety of OAuth methods, but every valid method would need to be linked to an email, the email would dictate unique users, and if an email was registered in duplicate I would prompt users to sign in with (that original provider) and autheticate their new provider from there._

_The user table would just contain an email, and separate provider tables would exist for each provider, and users would be able to add as many providers as they wanted to their accounts to enable additional features._

We will use the `get_by` function to search for existing users with the email provided by Github.

**The authentication plan:**

1. User OAuths with Github
2. We insert the records into Postgres
3. Database record gets an ID for the user
4. That ID is placed in the user cookie
5. Cookie is sent back to the server on repeated requests  
   (This is a **session**)

Cookies are on encrypted strings and are not user editable.

```ex
defmodule Discuss.AuthController do
  use Discuss.Web, :controller
  plug Ueberauth

  # Just type 'User' instead of 'Discuss.User'
  alias Discuss.User

  def callback(conn, params) do
    # Pull the 'auth' struct off the connection.
    %{assigns: %{ueberauth_auth: auth}} = conn
    user_params = %{
      token: auth.credentials.token,
      email: auth.info.email,
      provider: Atom.to_string(auth.provider)
    }

    IO.inspect(user_params)

    # Make our changeset:
    changeset = User.changeset(%User{}, user_params)

    # TODO: Insert records.
    signin(conn, changeset)

    conn
    |> put_flash(:info, "Welcome back!")
    |> redirect(to: topic_path(conn, :index))
  end

  defp insert_or_update_user(changeset) do
    # If this returns nil, we should add the user, otherwise it'll return a user
    case Repo.get_by(User, email: changeset.changes.email) do
      nil -> Repo.insert(changeset)
      user -> {:ok, user}  # (same return format as repo.get_by)
    end
  end

  defp signin(conn, changeset) do
    case insert_or_update_user(changeset) do
      {:ok, user} ->
        conn
        |> put_flash(:info, "Welcome back! (You are logged in.)")
        |> put_session(:user_id, user.id)  # we add the user ID to the session.
        |> redirect(to: topic_path(conn, :index))
        # Now the user is 'logged in'.
      {:error, reason } ->
        IO.inspect(reason)
        conn
        |> put_flash(:error, "Failed to sign in.")
        |> redirect(to: topic_path(conn, :index))
    end
  end
end
```

## Plugs in Phoenix 1.2

Plugs transform requests. Each plug does a small transformation on the connection struct.

**Module plugs** are standalone, better for organizing large plugs, better for use in multiple controllers.

**Function plugs** are better for use in a single controller.

**Create the directory `/web/controllers/plugs`.** Add `plugs/set_user.ex`, and let's start to assemble our first plug to help with our authentication process. Start the plug like this:

```ex
defmodule Discuss.Plugs.SetUser do
  import Plug.Conn
  import Phoenix.Controller

  alias Discuss.Repo
  alias Discuss.User

  # A plug module must define init and call functions

  def init(_params) do
  end

  def call(conn, _params) do
  end

end
```

The **cond** statement (heh, lisp vibes,) evaluates each statement in a similar form to **case** and executes the first statement that evaluates as true.

Similar to react, Elixir handles booleans compared with `&&` like react, where it returns the first false or the final true.

The finished plug to grab the user from the session looks like:

```ex
defmodule Discuss.Plugs.SetUser do
  import Plug.Conn
  import Phoenix.Controller

  alias Discuss.Repo
  alias Discuss.User

  # A plug module must define init and call functions

  def init(_params) do
  end

  def call(conn, _params) do

    # get_session comes from Phoenix.Controller
    user_id = get_session(conn, :user_id)

    # Cond implicitly returns a connection
    #  with or without a user attached
    cond do
      user = user_id && Repo.get(User, user_id) ->
        # assign is a helper to update the assigns struct
        # assign comes from Plug.Conn
        assign(conn, :user, user)
      true ->
        assign(conn, :user, nil)
    end
  end
end
```

At the end of your `:browser` pipeline, add:

```ex
plug Discuss.Plugs.SetUser
```

Nice.

## Showing Login Status

In `app.html.eex` the navbar can be augmented with:

```html
<nav class="light-blue">
  <div class="nav-wrapper container">
    <a href="/" class="brand-logo">Discussions</a>
    <ul class="right">
      <!-- is the user signed in or not? -->
      <%= if @conn.assigns[:user] do %>
      <li>Logout</li>
      <% else %>
      <li>
        <%= link "Sign in with Github", to: auth_path(@conn, :request, :github)
        %>
      </li>
      <% end %>
    </ul>
  </div>
</nav>
```

**(MAGIC)** Like `topic_path` before, `auth_path` will enable us to call methods within the Auth controller.

## Logging Out

Add the following to your router:

```
# Logout route
get "/signout", AuthController, :signout
```

...at the **top**. If you add it after the other routes, it will assume that you want to use the 'signout' provider. Not good!

Add this to `AuthController`:

```ex
def signout(conn, changeset) do
  conn
  # My guess: |> put_session(:user_id, nil)
  # This instead drops all session data:
  |> configure_session(drop: true)
  |> redirect(to: topic_path(conn, :index))
end
```

Our **Github OAuth flow is complete!**

## Securing User Data: Controller Scope Plugs

Let's make sure:

- Only users who are signed in can view the 'create post' page and submit a post.
- Users can ony edit their own posts.

Make a new plug called `RequireAuth`.

```ex
defmodule Discuss.Plugs.RequireAuth do
  import Plug.Conn  # gives halt
  import Phoenix.Controller  # gives put_flash and redirect

  alias Discuss.Router.Helpers

  def init(_params) do
  end

  def call(conn, _params) do
    # If you are signed in, carry on, else go home
    if conn.assigns[:user] do
      conn  # returning the conn object is how you end a plug
    else
      conn
      |> put_flash(:error, "You must be logged in to do that.")
      # Use 'Helpers'
      |> redirect_to(to: Helpers.topic_path(conn, :index))
      |> halt()  # SEND IT BACK NOW. From Plug.Conn
      # halt: plugs can end a connection before they get to the controller
    end
  end
end
```

How do we only apply this plug to particular routes?

To plug this to every handler in a module we'd include it at the top under the `use`/`alias` statements like so:

```ex
defmodule Discuss.TopicController do
  use Discuss.Web, :controller
  alias Discuss.Topic
  plug Discuss.Plugs.RequireAuth
  # ...
```

We will add a **guard clause** to ensure it only runs on specific actions.

```ex
plug Discuss.Plugs.RequireAuth when
  action in [:new, :create, :edit, :update, :delete]
```

...and it works.

## Who Owns That Post? (Update Migration)

A single user can make many topics. A topic only belongs to one user. A one-to-many relation is best.

Let's add a column to our table of topics called `user_id`.

First, create the migration file.

```
> mix ecto.gen.migration add_user_id_to_topics
Generated discuss app
* creating priv/repo/migrations
* creating priv/repo/migrations/20221220050357_add_user_id_to_topics.exs
```

Write the migration.

```ex
defmodule Discuss.Repo.Migrations.AddUserIdToTopics do
  use Ecto.Migration

  def change do
    alter table(:topics) do
      add :user_id, references(:users)
    end
  end
end
```

Run the migration.

```
> mix ecto.migrate
[info] == Running Discuss.Repo.Migrations.AddUserIdToTopics.change/0 forward
[info] alter table topics
[info] == Migrated in 0.0s
```

Django does actually have a better ORM from this perspective: migrations are created automatically as models are edited and updated. This does not negate the advantages of Phoenix. Besides, these things have probably been added to Phoenix since this release, as it has moved forward by at least 3 or for major iterations.

Still, we must manually set up this relationship in Phoenix in the User model:

```ex
# -> in models/user.ex
schema "users" do
  field :email, :string
  field :provider, :string
  field :token, :string
  has_many :topics, Discuss.Topic

  timestamps()
end

# -> in models/topic.ex
schema "topics" do
  field :title, :string
  belongs_to :user, Discuss.User
end
```

```
> iex.bat -S mix
Interactive Elixir (1.5.3) - press Ctrl+C to exit (type h() ENTER for help)
iex(1)> Discuss.Repo.get(Discuss.User, 1)
[debug] QUERY OK source="users" db=0.0ms
SELECT u0."id", u0."email", u0."provider", u0."token", u0."inserted_at", u0."updated_at" FROM "users" AS u0 WHERE (u0."id" = $1) [1]
%Discuss.User{__meta__: #Ecto.Schema.Metadata<:loaded, "users">,
 email: " < email > ", id: 1,
 inserted_at: ~N[2022-12-19 20:49:03.464000], provider: "github",
 token: " < token > ",
 topics: #Ecto.Association.NotLoaded<association :topics is not loaded>,
 updated_at: ~N[2022-12-19 20:49:03.477000]}
```

**(ANTI-MAGIC)** Whenever we fetch an item from the database with associations, Phoenix by default will **not** load the associated records. More code must be written to fetch these additional relations.

In the Topic Controller, we will use [build_assoc/3](https://hexdocs.pm/ecto/2.0.5/Ecto.html#build_assoc/3) to add the user to the topic struct:

```ex
def create(conn, %{"topic" => topic}) do
  # current user is conn.assigns[:user] or conn.assigns.user
  # old:  changeset = Topic.changeset(%Topic{}, topic)
  changeset = conn.assigns.user
  |> build_assoc(:topics)
  |> Topic.changeset(topic)

  case Repo.insert(changeset) do
    {:ok, _post} ->
      conn
      |> put_flash(:info, "Topic Created")
      |> redirect(to: topic_path(conn, :index))
    {:error, err_changeset} -> render conn, "new.html", changeset: err_changeset
  end
end
```

Checking our records, we can now see that new records have the `user_id` association correctly set:

```
id   title                         user_id
9    "Yeeehaw Conspiracy"          nil
11   "Test ID with association 2"  1
```

Good, the **association with the user is now saved to the db.**

The list view `/topic/index.html.eex` can now be updated:

```html
<h2>Topics</h2>

<ul class="collection">
  <!-- Let's iterate through the *topics* list -->
  <%= for topic <- @topics do %>
  <li class="collection-item">
    <%= topic.title %> <%= if @conn.assigns.user.id == topic.user_id do %>
    <div class="right">
      <%= link "Edit", to: topic_path(@conn, :edit, topic) %> <%= link "Delete",
      to: topic_path(@conn, :delete, topic), method: :delete %>
    </div>
    <% end %>
  </li>
  <% end %>
</ul>
```

Comparing `@conn.assigns.user.id == topic.user_id` allows us to only show options that won't cause the user to be error-redirected.

We must also enforce ownership on edit, update, and delete. We can do this with another plug.

## Who Can Edit That Post? (Function Plugs)

Add to the topic controller:

```ex
plug :check_post_owner when
  action in [:update, :edit, :delete]
```

...this will check the current module for a function plug called `check_post_owner`.

Now just write the function plug and things will work:

```ex
# FUNCTION PLUG
def check_post_owner(conn, _params) do
  # If the post has the same user_id as the user, pass, otherwise halt
  %{params: %{"id" => topic_id}} = conn

  if Repo.get(Topic, topic_id).user_id == conn.assigns.user.id do
    conn
  else
    conn
    |> put_flash(:error, "You do not own that resource.")
    |> redirect(to: topic_path(conn, :index))
    |> halt()
  end
end
```

# Phoenix 1.2: Channels

We're going to add commenting functionality to our topics, and use websockets to send live updates to anybody viewing the page, so the topic stays updated.

It's going to work something like this:

1. User fills out a comment form and hits 'submit'
2. Server receives emitted websocket event
3. Server catches event and creates comment
4. Server emits event with new list of comments to all clients

Our router already implements `resources` so the path to 'get' a single item is already set to the atom `:show` and we just need to write the function in our topic controller.

```ex
def show(conn, %{"id" => topic_id}) do
  topic = Repo.get!(Topic, topic_id)
  render conn, "show.html", topic: topic
end
```

Now in `topic/show.html.eex` write:

```html
<%= @topic.title %>
```

And add links to this page in `topic/index.html.eex` like so:

```html
(id=<%= topic.id %>) <%= link topic.title, to: topic_path(@conn, :show, topic)
%>
```

Navigating to a topic should work now.

## Adding the Comment Model

Let's add our comments migration:

```
> mix ecto.gen.migration add_comments
* creating priv/repo/migrations
* creating priv/repo/migrations/20221220221319_add_comments.exs
```

Write the migration and run it:

```ex
defmodule Discuss.Repo.Migrations.AddComments do
  use Ecto.Migration

  def change do
    create table(:comments) do
      add :content, :string
      add :user_id, references(:users)
      add :topic_id, references(:topics)

      timestamps()
    end
  end
end
```

```
> mix ecto.migrate
[info] == Running Discuss.Repo.Migrations.AddComments.change/0 forward
[info] create table comments
[info] == Migrated in 0.0s
```

Create `models/comment.ex` and add:

```ex
defmodule Discuss.Comment do
  use Discuss.Web, :model

  schema "comments" do
    field :content, :string
    belongs_to :user, Discuss.User
    belongs_to :topic, Discuss.Topic

    timestamps()
  end

  def changeset(struct, params \\ %{}) do
    struct
    |> cast(params, [:content])
    |> validate_required([:content])
  end
end
```

In the `User` and `Topic` models add:

```ex
has_many :comments, Discuss.Comment
```

...the relational structure is complete.

## Setting Up Channels

Channels must implement **join** and **handle_in**. Join is run when a user initially joins a channel. Handle-in is invoked whenever an event comes from the user's client.

**If we want to use Elixir with any sort of PWA we'll likely use channels to move data back and forth.**

The default Phoenix socket implementation has two sides:

**-> socket.js** for the client side

```js
import { Socket } from "phoenix";

let socket = new Socket("/socket", { params: { token: window.userToken } });

socket.connect();

// Now that you are connected, you can join channels with a topic:
let channel = socket.channel("topic:subtopic", {});
channel
  .join()
  .receive("ok", (resp) => {
    console.log("Joined successfully", resp);
  })
  .receive("error", (resp) => {
    console.log("Unable to join", resp);
  });

export default socket;
```

**-> user_socket.ex** for the server side

```ex
defmodule Discuss.UserSocket do
  use Phoenix.Socket

  # channel "room:*", Discuss.RoomChannel

  transport :websocket, Phoenix.Transports.WebSocket

  def connect(_params, socket) do
    {:ok, socket}
  end

  def id(_socket), do: nil
end
```

...both of these have loads of comments and disabled code with instructions, which have been removed as we'll explain the necessary additions.

For this implementation we'll just be implementing a single channel per resource, and that resource in this case is `Comments`.

Create the file `web/channels/comments_channel.ex` and write:

```ex
defmodule Discuss.CommentsChannel do
  use Discuss.Web, :channel

  def join(), do: end
  def handle_in(), do: end
end
```

Add this line to `user_socket.ex` below the commented channel line:

```ex
channel "comments:*", Discuss.CommentsChannel
```

The `*` here is a **wildcard** meaning all matching traffic to this route will be forwarded to the `CommentsChannel` module.

Docs: [Phoenix 1.2.5 - join(topic, auth_msg, arg2)](https://hexdocs.pm/phoenix/1.2.5/Phoenix.Channel.html#c:join/3)

Join is called whenever a JavaScript client attempts to join a channel.

To see the most basic working example, modify `comments_channel.ex` to read:

```ex
defmodule Discuss.CommentsChannel do
  use Discuss.Web, :channel

  def join(name, _params, socket) do
    IO.puts("+++++++++++++++++++++++++++++++++++++++++++++")
    IO.puts(name)
    {:ok, %{ test: "value1" }, socket}
  end
  def handle_in() do

  end
end
```

In `socket.js` change `socket.channel`'s string argument to `"comments:1"`.

In `app.js` uncomment the final line to import the socket.

If you run your app, the browser console will now show:

```
Joined successfully {test: 'value1'}
```

The server console will show:

```
[info] Sent 200 in 0┬╡s
+++++++++++++++++++++++++++++++++++++++++++++
[info] JOIN comments:1 to Discuss.CommentsChannel
  Transport:  Phoenix.Transports.WebSocket
  Parameters: %{}
comments:1
[info] Replied comments:1 :ok
```

How this is all working:

1. When the web app is opened, `socket.js` is run and attempts to join the channel `comments:1`.
2. On the server side, the UserSocket handles all socket calls. A channel is defined to handle requests to `comments:*` and all requests are automatically accepted and passed to CommentsChannel.
3. CommentsChannel prints the name of the channel and sends back a map.
4. The map is printed as part of the success case on the client side.

If you **add a button** to the show template, like so:

```html
<button id="ping0">Ping!</button>
```

And write a `handle_in` function:

```ex
defmodule Discuss.CommentsChannel do
  use Discuss.Web, :channel

  def join(name, _params, socket) do
    {:ok, %{ test: "value1" }, socket}
  end

  def handle_in(name, message, socket) do
    IO.puts("+++++++++++++++++")
    IO.puts(name)
    IO.inspect(message)
    {:reply, :ok, socket} # reply to the user, all is fine.
  end
end
```

...and finally write some js to push an update when that button is clicked...

```js
document.getElementById("ping0").addEventListener("click", function () {
  channel.push("comment:hello", { hi: "this is new data!" });
});
```

...you will see the channel update on the server side:

```
[info] JOIN comments:1 to Discuss.CommentsChannel
  Transport:  Phoenix.Transports.WebSocket
  Parameters: %{}
[info] Replied comments:1 :ok
+++++++++++++++++
comment:hello
%{"hi" => "this is new data!"}
```

## Joining the Correct Channel

Now we will completely refactor our client side Javascript to a class that takes the topic ID as an argument and joins the correct channel, then grabs the latest few comments and loads new ones when they are sent.

```js
socket.connect();

function createSocket(topicId) {
  let channel = socket.channel(`comments:${topicId}`, {});
  channel
    .join()
    .receive("ok", (resp) => {
      console.log("Joined successfully", resp);
    })
    .receive("error", (resp) => {
      console.log("Unable to join", resp);
    });
}

window.createSocket = createSocket;
```

Now we can mix Elixir, HTML, and JS to set this up client side:

```html
<%= @topic.title %>
<script>
  document.addEventListener("DOMContentLoaded", function(){
    window.createSocket(<%= @topic.id %>);
  });
</script>
```

Finally, update the `app.js` file's last line to read:

```js
import "./socket";
```

...so the file is simply executed.

The reason we are building things this way is because we only want this Javascript to run when a _show_ template is opened.

When opening a show view, the console will now show:

```
[info] Sent 200 in 0┬╡s
[info] JOIN comments:3 to Discuss.CommentsChannel
  Transport:  Phoenix.Transports.WebSocket
  Parameters: %{}
```

## Sending Data to the Server

Let's create a simple little form to create comments.

(On my personal site, when I write my own commenting engine, do a little check when creating a new comment-area to see if the page really exists on one of my own domains. Authenticate with GitHub and permanently ban users if they post more than 3 comments in 3 seconds.)

(As a side project, you could scale this to an advance wars type of game. Would be cool to ramp that up to a battlesnake model.)

Update `show.html.eex`:

```html
<h5><%= @topic.title %></h5>

<div class="input-field">
  <textarea id="comment-textarea" class="materialize-textarea"></textarea>
  <button id="submit-comment" class="btn">Add Comment</button>
</div>

<script>
  document.addEventListener("DOMContentLoaded", function(){
    window.createSocket(<%= @topic.id %>);
  });
</script>
```

Update `socket.js`:

```js
socket.connect();

function createSocket(topicId) {
  let channel = socket.channel(`comments:${topicId}`, {});
  channel
    .join()
    .receive("ok", (resp) => {
      console.log("Joined successfully", resp);
    })
    .receive("error", (resp) => {
      console.log("Unable to join", resp);
    });

  const textArea = document.getElementById("comment-textarea");
  const submitBtn = document.getElementById("submit-comment");

  submitBtn.addEventListener("click", function () {
    const content = textArea.value;
    channel.push("comment:add", { content: content });
  });
}
window.createSocket = createSocket;
```

```
[info] Replied comments:3 :ok
+++++++++++++++++
comment:add
%{"content" => "asdf"}
```

Nice. Let's extract that and add it to the database.

**(MAGIC)** there is no state stored in an object, but the **socket struct is much like our connection struct and can hold some data for us.**

We use an `assign` to stash the topic info in our socket.

We stash the comment value in the database when we receive it.

```ex
defmodule Discuss.CommentsChannel do
  use Discuss.Web, :channel
  alias Discuss.{Topic, Comment}

  def join("comments:" <> topic_id_str, _params, socket) do
    topic_id = String.to_integer(topic_id_str)
    topic = Repo.get(Topic, topic_id)
    {:ok, %{ test: "value1" }, assign(socket, :topic, topic)}
  end

  def handle_in(name, %{"content" => content}, socket) do
    topic = socket.assigns.topic

    changeset = topic
    # build an empty comment associated with our topic
    |> build_assoc(:comments)
    # add in the content from the user
    |> Comment.changeset(%{ content: content })

    case Repo.insert(changeset) do
      {:ok, comment} ->
        {:reply, :ok, socket}
      {:error, _reason} ->
        {:reply, {:error, %{errors: changeset}}, socket}
    end
  end
end
```

```
[debug] QUERY OK db=0.0ms
INSERT INTO "comments" ("content","topic_id","inserted_at","updated_at") VALUES ($1,$2,$3,$4) RETURNING "id"
["first comment!", 3, {{2022, 12, 23}, {19, 49, 20, 390000}}, {{2022, 12, 23}, {19, 49, 20, 390000}}]
[debug] QUERY OK db=16.0ms
```

## Sending Data Back to the Client

**(MAGIC)** Here's another really great **pattern matching** example to ensure the client joins the correct channel:

```ex
def join("comments:" <> topic_id, _params, socket) do
```

This will **pattern match the string** and extract the number on the end into the variable `topic_id`. In any other language, this operation would take at least a couple more lines. Not so with Elixir!!! Magic `<>`. Unfortunately it does still pull it out as a string, so we'll need to specify that conversion.

...unfortunately at this point the Poison encoder will blow up if we just try and fling the Topic struct we get back from the database (using `Repo.get` with our topic id,) back to the client.

Though we _could_ prerender the comments on the template, we are going to render all the comments via the socket for simplicity.

Let's first grab the comments associated with the article:

```ex
topic_id = String.to_integer(topic_id_str)
topic = Repo.get(Topic, topic_id)
  |> Repo.preload(:comments)

{:ok, %{ comments: topic.comments },
  assign(socket, :topic, topic)}
```

...trying to run this now and return `topic.comments` will throw a huge error. The JSON form of the model must be specified. This can be done by specifying the fields to send in `comment.ex` with one line:

```ex
@derive {Poison.Encoder, only: [:content, :inserted_at]}
```

The browser will now show the comments like so:

```js
{
  inserted_at: '2022-12-23T19:49:20.390000',
  content: 'first comment!'
},
{
  inserted_at: '2022-12-23T21:45:40.959000',
  content: 'Wow this is great'
}
```

**Great.**

Now let's render them. Add this to your show html:

```html
<ul id="comments" class="collection"></ul>
```

...and pass `resp.comments` into a function like this:

```js
function renderComments(comments) {
  const output = comments.map((comment) => {
    return `<li class="collection-item">
      ${comment.content}
    </li>`;
  });

  document.getElementById("comments").innerHTML = output.join("");
}
```

## Broadcasting Updates to All Users

Before the OK reply in `handle_in` add:

```ex
broadcast!(
  socket,
  "comments:#{socket.assigns.topic.id}:new",
  %{ comment: comment }
  )
```

This event will be broadcast to everyone else on the socket. On the client side, add this line to your `createSocket` function:

```js
channel.on(`comments:${topicId}:new`, renderComment);
```

And outside that:

```js
function renderComment(resp) {
  document.getElementById("comments").innerHTML += commentTemplate(
    resp.comment.content
  );
}

function commentTemplate(text) {
  return `<li class="collection-item">
      ${text}
    </li>`;
}
```

Broadcast will now function. Beautifully.

## Socket Authentication

So far comments are being added with zero authentication. Whoops!

To do this, we'll get the client-side Javascript to send back a token we embed into the layout. The user will be added to the socket once the token is verified.

In the head of `app.html.eex` add:

```html
<script>
  <%= if @conn.assigns.user do %>
    window.userToken = "<%= Phoenix.Token.sign(Discuss.Endpoint, "key", @conn.assigns.user.id) %>"
  <% end %>
</script>
```

**Phoenix already assumes the token will be made available like this.**

```js
let socket = new Socket("/socket", { params: { token: window.userToken } });
```

In `user_socket.ex` modify the connect function:

```ex
def connect(%{"token" => token}, socket) do
  case Phoenix.Token.verify(socket, "key", token) do
  {:ok, user_id} ->
    {:ok, assign(socket, :user_id, user_id)}
  {:error, _error} -> :error
  end
end
```

...to then associate this with the user, we need to use `build_assoc` in an ugly way like this:

```ex
|> build_assoc(:comments, user_id: socket.assigns.user_id)
```

Done.

## Loading User Profiles with Comments

As easy as:

```ex
|> build_assoc(:comments, user_id: socket.assigns.user_id)
```

Update the Poison encoders:

```ex
# In Comment
@derive {Poison.Encoder, only: [:content, :inserted_at, :user]}

# In User
@derive {Poison.Encoder, only: [:email]}
```

Updating your `commentTemplate` function will render the user email at the end of each comment.

```js
function commentTemplate(comment) {
  let email = "Anon";
  if (comment.user) {
    email = comment.user.email;
  }

  return `<li class="collection-item">
      ${comment.content}
      <div class="secondary-content">${email}</div>
    </li>`;
}
```

## Project Files

Download the [.zip](/discuss.zip)

# Phoenix 1.3

[phoenixframework.org/blog/phoenix-1-3-0-released](https://www.phoenixframework.org/blog/phoenix-1-3-0-released)

Differences in Phoenix 1.3:

- New command shortcuts (`phoenix -> phx`)
- New directory structure
  - Web folder is split (biz logic, web communication)
  - Client assets folder moved

In our _Discuss_ application, we had three models: _Users, Topics,_ and _Comments_. With **Contexts**, these models would be grouped by systems, so _Users_ and _Topics & Comments_ would be split into **two** separate contexts, and not three, perhaps named **Accounts** and **Posts**.

You could then spin up the models like so:

```
mix phx.gen.html <Context> <Model> <table> [fields <title:type>]

mix phx.gen.html Accounts User users email:string
mix phx.gen.html Discussions Topic topics title:string
mix phx.gen.html Discussions Comment comments content:string
```

This automatically creates not only the (for example,) User schema/model in one file, it also creates CRUD function helpers in the higher context for easy manipulation of the model.

**The Context serves as a high-level interface for working with all models within a system.**

# Phoenix 1.6.15

The current version at time of writing.

See ['Why Elixir & Phoenix is a great choice for your web app in 2022'](https://curiosum.com/blog/why-elixir-phoenix-great-choice-for-modern-web-app)
for a rundown on why Phoenix/Elixir is a good choice for productive web development.

I'll be adding notes here with my personal experiences and successes/failures using the framework.

## Notes for Chat App

- Store 'latest seen message' in User-Convo through model.

## Cool Feature: Seeds

Every Phoenix project has a `priv/repo/seeds.exs` directory.

```
# Script for populating the database. You can run it as:
#
#     mix run priv/repo/seeds.exs
#
# Inside the script, you can read and write to any of your
# repositories directly:
#
#     HighTowerV3.Repo.insert!(%HighTowerV3.SomeSchema{})
#
# We recommend using the bang functions (`insert!`, `update!`
# and so on) as they will fail if something goes wrong.
```

...hot damn, that's very useful for nuking the database and starting again from scratch. I'd done this with scripts in the past, but it's nice to see it was thought of here.



## Phoenix LiveView 0.17.2 Example 1

I'm taking a break from attempting to build my first chat application, _High Tower,_ to take a tutorial. I have a weak grip on Ecto and how it handles complex relationships.

Notes from this [PHX LiveView Tutorial](https://curiosum.com/blog/elixir-phoenix-liveview-messenger-part-2)
and other sources.

```sh
# Stop using the ancient Postgres 9 for projects ;)
docker run --name phoenix-dev-db -p 5432:5432
  -e POSTGRES_PASSWORD=postgres -d postgres:latest
```

Here's a description of what we are building:

> We want to store users communicating messages between them. Each message is part of a conversation, which is associated with two or more users, with a message always having a specified sender.
>
> As in most modern instant messaging apps, we want a "Message Seen" feature that tracks which conversation members have seen a message, in which every information about who's seen a message has a specific timestamp.
>
> We would also like to have a Slack-like emoji reaction system, in which any conversation member can react to a message with one or more defined emojis, all of which have a name and a Unicode representation.

Let's bootstrap our schemas and migrations with the following commands:

```sh
mix phx.new high_tower_v3
mix ecto.create
mix phx.gen.context Auth User auth_users nickname:string
mix phx.gen.context Chat Conversation chat_conversations title:string
mix phx.gen.context Chat ConversationMember chat_conversation_members conversation_id:references:chat_conversations user_id:references:auth_users owner:boolean
mix phx.gen.context Chat Message chat_messages conversation_id:references:chat_conversations user_id:references:auth_users content:text
mix phx.gen.context Chat Emoji chat_emojis key:string unicode:string
mix phx.gen.context Chat MessageReaction chat_message_reactions message_id:references:chat_messages user_id:references:auth_users emoji_id:references:chat_emojis
mix phx.gen.context Chat SeenMessage chat_seen_messages user_id:references:auth_users message_id:references:chat_messages
```

Breaking this apart line by line.

Creating a simple user (we will improve auth later.)

```sh
mix phx.gen.context Auth User auth_users
  nickname:string
```

Everything else is in the **Chat context**.

At a high level, our Chat object only contains a _title_.

```sh
mix phx.gen.context Chat Conversation chat_conversations
  title:string
```

ConversationMember is something like a _through-model_ that relates users to conversations, and includes an additional bit of information to store the admins of the chat.

```sh
mix phx.gen.context Chat ConversationMember chat_conversation_members
  conversation_id:references:chat_conversations
  user_id:references:auth_users
  owner:boolean
```

Message references a conversation and user, and holds the message content.

```sh
mix phx.gen.context Chat Message chat_messages
  conversation_id:references:chat_conversations
  user_id:references:auth_users
  content:text
```

All of our Emoji are stored in a table as well:

```sh
mix phx.gen.context Chat Emoji chat_emojis
  key:string
  unicode:string
```

Our reactions reference three different tables:

```sh
mix phx.gen.context Chat MessageReaction chat_message_reactions
  message_id:references:chat_messages
  user_id:references:auth_users
  emoji_id:references:chat_emojis
```

Seen similarly is a relation between users and messages.

(**[!!]** Jeez, this table will be absolutely massive. Rows = messages \* users in a channel. With 100 users, this table will be 100 times the length of the messages table, unless it only references the _latest message the user has seen,_ but it would be **better to store that in the ConversationMember data.**)

```sh
mix phx.gen.context Chat SeenMessage chat_seen_messages
  user_id:references:auth_users
  message_id:references:chat_messages
```

This will all add **20 files and 1,412 LoC.**

**We still need to make some schema changes and modifications to the migrations generated by `phx.gen.context`.** Follow the tutorial for those changes.

**Oh, this app simply does not use many to many Ecto functions.** Let's follow through anyhow.

Here are the changes that were made:

**Conversation** didn't need a schema change, you can just put has_many to indicate a foreignkey on another model.

```diff
+++ b/lib/high_tower_v3/chat/conversation.ex
defmodule HighTowerV3.Chat.Conversation do
   use Ecto.Schema
   import Ecto.Changeset

+  # Simplify appearance of Schema
+  alias HighTowerV3.Chat.{ConversationMember, Message}
+
   schema "chat_conversations" do
     field :title, :string

+    has_many :conversation_members, ConversationMember
+    has_many :messages, Message
+
     timestamps()
   end
```

```diff
+++ b/lib/high_tower_v3/chat/conversation_member.ex
@@ -2,10 +2,17 @@ defmodule HighTowerV3.Chat.ConversationMember do
   use Ecto.Schema
   import Ecto.Changeset

+  # Simplify appearance of Schema
+  alias HighTowerV3.Chat.Conversation
+  alias HighTowerV3.Auth.User
+
   schema "chat_conversation_members" do
     field :owner, :boolean, default: false
-    field :conversation_id, :id
-    field :user_id, :id
+    # field :conversation_id, :id
+    # field :user_id, :id
+
+    belongs_to :user, User
+    belongs_to :conversation, Conversation

     timestamps()
   end
@@ -13,7 +20,9 @@ defmodule HighTowerV3.Chat.ConversationMember do
   @doc false
   def changeset(conversation_member, attrs) do
     conversation_member
-    |> cast(attrs, [:owner])
-    |> validate_required([:owner])
+    |> cast(attrs, [:owner, :conversation_id, :user_id])
+    |> validate_required([:owner, :conversation_id, :user_id])
+    |> unique_constraint(:user, name: :chat_conversation_members_conversation_id_user_id_index)
+    |> unique_constraint(:conversation_id, name: :chat_conversation_members_owner)
   end
 end

```

```diff
+++ b/lib/high_tower_v3/chat/message.ex
@@ -1,11 +1,21 @@
 defmodule HighTowerV3.Chat.Message do
+  alias HighTowerV3.Chat.SeenMessage
+  alias Hex.API.User
+  alias HighTowerV3.Chat.Conversation
   use Ecto.Schema
   import Ecto.Changeset

+  alias HighTowerV3.Auth.User
+  alias HighTowerV3.Chat.{Conversation, SeenMessage, MessageReaction}
+
   schema "chat_messages" do
     field :content, :string
-    field :conversation_id, :id
-    field :user_id, :id
+
+    belongs_to :conversation, Conversation
+    belongs_to :user, User
+
+    has_many :seen_messages, SeenMessage
+    has_many :message_reactions, MessageReaction

     timestamps()
   end
@@ -13,7 +23,7 @@ defmodule HighTowerV3.Chat.Message do
   @doc false
   def changeset(message, attrs) do
     message
-    |> cast(attrs, [:content])
-    |> validate_required([:content])
+    |> cast(attrs, [:content, :conversation_id, :user_id])
+    |> validate_required([:content, :conversation_id, :user_id])
   end
 end
```

```diff
+++ b/lib/high_tower_v3/chat/message_reaction.ex
@@ -2,11 +2,13 @@ defmodule HighTowerV3.Chat.MessageReaction do
   use Ecto.Schema
   import Ecto.Changeset

-  schema "chat_message_reactions" do
+  alias HighTowerV3.Auth.User
+  alias HighTowerV3.Chat.{Message, Emoji}

-    field :message_id, :id
-    field :user_id, :id
-    field :emoji_id, :id
+  schema "chat_message_reactions" do
+    belongs_to :message, Message
+    belongs_to :user, User
+    belongs_to :emoji, Emoji

     timestamps()
   end
@@ -14,7 +16,10 @@ defmodule HighTowerV3.Chat.MessageReaction do
   @doc false
   def changeset(message_reaction, attrs) do
     message_reaction
-    |> cast(attrs, [])
-    |> validate_required([])
+    |> cast(attrs, [:user_id, :emoji_id, :message_id])
+    |> validate_required([:user_id, :emoji_id, :message_id])
+    |> unique_constraint(:emoji_id,
+      name: :chat_message_reactions_user_id_message_id_emoji_id_index
+    )
   end
 end

```

```diff
+++ b/lib/high_tower_v3/chat/seen_message.ex
@@ -2,10 +2,12 @@ defmodule HighTowerV3.Chat.SeenMessage do
   use Ecto.Schema
   import Ecto.Changeset

-  schema "chat_seen_messages" do
+  alias HighTowerV3.Auth.User
+  alias HighTowerV3.Chat.Message

-    field :user_id, :id
-    field :message_id, :id
+  schema "chat_seen_messages" do
+    belongs_to :user, User
+    belongs_to :message, Message

     timestamps()
   end
@@ -13,7 +15,7 @@ defmodule HighTowerV3.Chat.SeenMessage do
   @doc false
   def changeset(seen_message, attrs) do
     seen_message
-    |> cast(attrs, [])
-    |> validate_required([])
+    |> cast(attrs, [:user_id, :message_id])
+    |> validate_required([:user_id, :message_id])
   end
 end
```

```diff
+++ b/priv/repo/migrations/20221229163822_create_auth_users.exs
@@ -3,9 +3,11 @@ defmodule HighTowerV3.Repo.Migrations.CreateAuthUsers do

   def change do
     create table(:auth_users) do
-      add :nickname, :string
+      add :nickname, :string, null: false

       timestamps()
     end
+
+    create unique_index(:auth_users, [:nickname])
   end
 end
```

```diff
+++ b/priv/repo/migrations/20221229163823_create_chat_conversations.exs
@@ -3,7 +3,7 @@ defmodule HighTowerV3.Repo.Migrations.CreateChatConversations do

   def change do
     create table(:chat_conversations) do
-      add :title, :string
+      add :title, :string, null: false

       timestamps()
     end
```

```diff
+++ b/priv/repo/migrations/20221229163827_create_chat_conversation_members.exs
@@ -4,13 +4,22 @@ defmodule HighTowerV3.Repo.Migrations.CreateChatConversationMembers do
   def change do
     create table(:chat_conversation_members) do
       add :owner, :boolean, default: false, null: false
-      add :conversation_id, references(:chat_conversations, on_delete: :nothing)
-      add :user_id, references(:auth_users, on_delete: :nothing)
+      add :conversation_id, references(:chat_conversations, on_delete: :nothing), null: false
+      add :user_id, references(:auth_users, on_delete: :nothing), null: false

       timestamps()
     end

     create index(:chat_conversation_members, [:conversation_id])
     create index(:chat_conversation_members, [:user_id])
+
+    # New
+    # Ensure each user can only be associated with a conversation once.
+    create unique_index(:chat_conversation_members, [:conversation_id, :user_id])
+    # Ensure each conversation can only have a single owner.
+    create unique_index(:chat_conversation_members, [:conversation_id],
+      where: "owner = TRUE",
+      name: "chat_conversation_members_owner"
+    )
   end
 end

```

```diff
+++ b/priv/repo/migrations/20221229163829_create_chat_messages.exs
@@ -4,8 +4,8 @@ defmodule HighTowerV3.Repo.Migrations.CreateChatMessages do
   def change do
     create table(:chat_messages) do
       add :content, :text
-      add :conversation_id, references(:chat_conversations, on_delete: :nothing)
-      add :user_id, references(:auth_users, on_delete: :nothing)
+      add :conversation_id, references(:chat_conversations, on_delete: :nothing), null: false
+      add :user_id, references(:auth_users, on_delete: :nothing), null: false

       timestamps()
     end
```

```diff
+++ b/priv/repo/migrations/20221229163831_create_chat_emojis.exs
@@ -3,8 +3,8 @@ defmodule HighTowerV3.Repo.Migrations.CreateChatEmojis do

   def change do
     create table(:chat_emojis) do
-      add :key, :string
-      add :unicode, :string
+      add :key, :string, null: false
+      add :unicode, :string, null: false

       timestamps()
     end
```

```diff
+++ b/priv/repo/migrations/20221229163833_create_chat_message_reactions.exs
@@ -3,9 +3,9 @@ defmodule HighTowerV3.Repo.Migrations.CreateChatMessageReactions do

   def change do
     create table(:chat_message_reactions) do
-      add :message_id, references(:chat_messages, on_delete: :nothing)
-      add :user_id, references(:auth_users, on_delete: :nothing)
-      add :emoji_id, references(:chat_emojis, on_delete: :nothing)
+      add :message_id, references(:chat_messages, on_delete: :nothing), null: false
+      add :user_id, references(:auth_users, on_delete: :nothing), null: false
+      add :emoji_id, references(:chat_emojis, on_delete: :nothing), null: false

       timestamps()
     end
@@ -13,5 +13,7 @@ defmodule HighTowerV3.Repo.Migrations.CreateChatMessageReactions do
     create index(:chat_message_reactions, [:message_id])
     create index(:chat_message_reactions, [:user_id])
     create index(:chat_message_reactions, [:emoji_id])
+
+    create unique_index(:chat_message_reactions, [:user_id, :message_id, :emoji_id])
   end
 end
```

```diff
+++ b/priv/repo/migrations/20221229163834_create_chat_seen_messages.exs
@@ -3,13 +3,14 @@ defmodule HighTowerV3.Repo.Migrations.CreateChatSeenMessages do

   def change do
     create table(:chat_seen_messages) do
-      add :user_id, references(:auth_users, on_delete: :nothing)
-      add :message_id, references(:chat_messages, on_delete: :nothing)
+      add :user_id, references(:auth_users, on_delete: :nothing), null: false
+      add :message_id, references(:chat_messages, on_delete: :nothing), null: false

       timestamps()
     end

     create index(:chat_seen_messages, [:user_id])
     create index(:chat_seen_messages, [:message_id])
+    create unique_index(:chat_seen_messages, [:user_id, :message_id])
   end
 end
```

One new thing I learned from this article is the concept of a **seed file** that contains a bunch of commands to bootstrap a development database. I've modified it a touch from the tutorial:

```ex
alias HighTowerV3.Auth.User
alias HighTowerV3.Chat.{Conversation, ConversationMember}
alias HighTowerV3.{Auth, Chat}

# Create a user, a conversation, and add members.
{:ok, %User{id: u1_id}} = Auth.create_user(%{nickname: "User One"})

{:ok, %Conversation{id: conv_id}} = Chat.create_conversation(%{title: "Modern Talking"})

{:ok, %ConversationMember{}} =
  Chat.create_conversation_member(%{conversation_id: conv_id, user_id: u1_id, owner: true})

# Add a bunch of non-owner users to the conversation.
for user <- ["Two", "Three", "Four", "Five", "Six"] do
  {:ok, %User{id: ux_id}} = Auth.create_user(%{nickname: "User " <> user})

  {:ok, %ConversationMember{}} =
    Chat.create_conversation_member(%{conversation_id: conv_id, user_id: ux_id, owner: false})
end
```

Cool.

**Now let's write that liveview. In the router:**

```
live "/conversations/:conversation_id/users/:user_id", ConversationLive
```

In new file `/live/conversation_live.ex` do:

```ex
defmodule HighTowerV3Web.ConversationLive do
  use HighTowerV3Web, :live_view
  use Phoenix.HTML

  alias HighTowerV3.{Auth, Chat, Repo}

  # Renders a template from data in assigns
  def render(assigns) do
  end

  # Prepares socket assigns needed to render the view
  def mount(assigns, socket) do
  end

  # Handle events triggered by the browser
  def handle_event(event, payload, socket) do
  end

  # After mount: Read query params, intercept param changes
  def handle_params(params, uri, socket) do
  end
end
```

Filling this out will give a working (if horrifically authenticated) chat window:

```ex
defmodule HighTowerV3Web.ConversationLive do
  use HighTowerV3Web, :live_view
  use Phoenix.HTML

  alias HighTowerV3.{Repo, Chat, Auth}

  # Renders a template from data in assigns
  def render(assigns) do
    ~L"""
    <div>
      <div>
      <b>User name:</b> <%= @user.nickname %>
      </div>
      <div>
        <b>Conversation title:</b> <%= @conversation.title %>
      </div>
      <div>
        <%= f = form_for :message, "#", [phx_submit: "send_message"] %>
          <%= label f, :content %>
          <%= text_input f, :content %>
          <%= submit "Send" %>
        </form>
      </div>
      <div>
        <b>Messages:</b>
        <%= for message <- @messages do %>
          <div>
            <b><%= message.user.nickname %></b>: <%= message.content %>
          </div>
        <% end %>
      </div>
    </div>
    """
  end

  # Prepares socket assigns needed to render the view
  def mount(_assigns, socket) do
    {:ok, socket}
  end

  # Handle events triggered by the browser
  def handle_event("send_message", %{"message" => %{"content" => content}}, socket) do
    %{assigns: %{conversation_id: conversation_id, user_id: user_id, user: user}} = socket

    case Chat.create_message(%{
           conversation_id: conversation_id,
           user_id: user_id,
           content: content
         }) do
      {:ok, new_message} ->
        new_message = %{new_message | user: user}
        updated_messages = socket.assigns[:messages] ++ [new_message]

        {:noreply, socket |> assign(:messages, updated_messages)}

      {:error, _} ->
        {:noreply, socket}
    end
  end

  # Handle events triggered by the browser
  def handle_event(_event, _payload, socket) do
    {:noreply, socket}
  end

  # After mount: Read query params, intercept param changes
  def handle_params(%{"conversation_id" => conversation_id, "user_id" => user_id}, _uri, socket) do
    {:noreply,
     socket
     |> assign(:user_id, user_id)
     |> assign(:conversation_id, conversation_id)
     |> assign_records()}
  end

  defp assign_records(%{assigns: %{user_id: user_id, conversation_id: conversation_id}} = socket) do
    user = Auth.get_user!(user_id)

    conversation =
      Chat.get_conversation!(conversation_id)
      |> Repo.preload(messages: [:user], conversation_members: [:user])

    socket
    # in real life, get user properly with user socket auth
    |> assign(:user, user)
    |> assign(:conversation, conversation)
    # very inefficient
    |> assign(:messages, conversation.messages)
  end
end
```


There is a [Part 3](https://curiosum.com/blog/elixir-phoenix-liveview-messenger-part-3) to this article that we will continue to follow to add PubSub/broadcasting to update each user in a room's chat window in realtime when a message is posted.

**END**
