#! /bin/bash

hugo gen chromastyles --style=perldoc > ./assets/css/code-light.css
# hugo gen chromastyles --style=tokyonight-storm > ./assets/css/code-dark.css
hugo gen chromastyles --style=vulcan > ./assets/css/code-dark.css
