I'm glad you've stumbled upon my *hugo* theme. Hugo has a few advangages over my previous staple SSG, *Jekyll*, and so I am migrating to it. This template has been built with the following features:

1. The **navbar** is sticky and has the usual BootStrap scroll-open menu. It is populated with all of the pages at the content root, plus a link to each section's index. No additional programming is needed to add pages to the navbar/menu.
2. All important text on the site is pulled from `config.toml`, so you (the user) don't have to dig through tons of HTML to change, for instance, the site title. This is certainly best practice, but this is my first reusable template, and I forgot about this important step at first.
3. **BootStrap!** Customizing this template is easy, as bootstrap has been included for easy container and element management.
4. Do note that the *Articles* section can be renamed to anything; posts, essays, journal entries; Hugo will pick up the changes and display the category properly in the menu. Just be sure to also modify the `_index.md` within the content folder to change the title and intro text for the section.

This index content is stored in the `_index.md` at the root of the content folder.