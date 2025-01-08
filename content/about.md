---
title: "About"
toc: true
summary: "This page contains information about the site, the author and the tools used to create the site."
---

This documentation site has a variety of features to make it wicked fast and useful.

# Ultra Fast

As technology evolves, the implementation of this site has changed to
adopt additional technologies.

## Site Version 2

Though additional niceties like a custom font and [FontAwesome](https://docs.fontawesome.com/) icons
have now been included, [HTMX](https://htmx.org/docs/) has been added and the
[hx-boost](https://htmx.org/attributes/hx-boost/) tag used
in order to skip `<head>` processing when navigating between pages.

## Site Version 1

A combination of inlined/minifed CSS, a system font stack, and deferred/async javascript means this website loads almost instantaneously, with no content drift.

```css
font-family: "SFMono-Regular", Consolas, Monaco, "Liberation Mono",
  "Noto Mono", Menlo, Courier, "Courier New", monospace !important;
```

# Syntax Highlighting

Code blocks can be scrolled to the left while remaining visible pat:

```javascript
function getTopicCount(topic) {
    const wiki = https.get(
        'https://en.wikipedia.org/w/api.php?action=parse&section=0&prop=text&weirdprop4=yabadabadoo&wild=fun&format=json&page='.concat(topic.trim()),
        (res) => {
            const response_array = [];
            res.on('data', (x) => {
                response_array.push(x.toString());
            }).on('end', () => {
                console.log((response_array.join('').match(new RegExp(topic, 'g')) || []).length);
            });
        }
    ).on('error', (err) => {
        console.log(`ERR -> wiki \n${err}`);
    });
}
```
