---
title: "About"
toc: true
summary: "This page contains information about the site, the author and the tools used to create the site."
---

This documentation site has a variety of features to make it wicked fast and useful.

# Ultra Fast

A combination of inlined/minifed CSS, a system font stack, and deferred/async javascript means this website loads almost instantaneously, with no content drift.

```css
font-family: "SFMono-Regular", Consolas, Monaco, "Liberation Mono",
  "Noto Mono", Menlo, Courier, "Courier New", monospace !important;
```

# Syntax Highlighting

Code blocks can be scrolled to the left while remaining visible pat:

```js
function getTopicCount(topic) {
    const https = require('https');
    const wiki = https.get(
        'https://en.wikipedia.org/w/api.php?action=parse&section=0&prop=text&format=json&page='.concat(topic.trim()),
        (res) => {
            const response_array = [];
            res.on('data', (x) => {
                response_array.push(x.toString());
            }).on('end', () => {
                console.log((response_array.join('').match(new RegExp(topic, 'g')) || []).length);
            }).on('error', (err) => {
                console.log(`ERR -> wiki -> res\n${err}`);
            });
        },
    ).on('error', (err) => {
        console.log(`ERR -> wiki \n${err}`);
    });
}
```
