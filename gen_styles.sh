#! /bin/bash

# Original Light = Perldoc, Dark = Vulcan

# Light Theme
hugo gen chromastyles --style=perldoc > ./assets/css/code-light.css

# Dark Theme
# hugo gen chromastyles --style=tokyonight-storm > ./assets/css/code-dark.css
# hugo gen chromastyles --style=vulcan > ./assets/css/code-dark.css
# hugo gen chromastyles --style=onedark > ./assets/css/code-dark.css
#hugo gen chromastyles --style=catppuccin-mocha > ./assets/css/code-dark.css

hugo gen chromastyles --style=doom-one > ./assets/css/code-dark.css
