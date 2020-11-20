"use strict";

/*
 * This is the scripts.js file for ryanfleck.ca
 *
 * It contains methods for checking the browser storage to apply
 * user preferences to the css, and controlling the settings modal.
 *
 */

/**
 * Feature 1
 * Adds tilde (~) anchor links to each header on the page.
 */
function addAnchorsToHeaders() {
  var headers = document.querySelectorAll("h1, h2, h3, h4, h5, h6");
  headers.forEach(function (header) {
    if (!header.classList.contains("page-title")) {
      if (header.id) {
        // Create the elements.
        var anchorLink = document.createElement("a");

        // Add required attributes.
        anchorLink.text = "~"; // Could be pilcrow ¶
        anchorLink.href = "#" + header.id;
        anchorLink.className = "header-anchor-link";
        anchorLink.style.float = "left";
        anchorLink.style.marginLeft = "-20px";

        // Append to header.
        header.appendChild(anchorLink);
      }
    }
  });
}

/**
 * Feature 2:
 * Add view counts to articles.
 */
function setPageViewCounts() {
  // Check local storage and page URL
  var id = localStorage.getItem("rcf_user_id") || "";
  var server_url = getServerUrl();
  var page_path = window.location.pathname;

  // Feature 2: Attempt to contact rcf-services on Heroku.
  var postData = {
    user_id: id,
    page_url: page_path,
  };

  fetch(server_url + "/api/view-counts/page-tracker/", {
    mode: "cors",
    method: "POST",
    headers: {
      "Content-Type": "application/json;charset=utf-8",
    },
    body: JSON.stringify(postData),
  })
    .then((res) => {
      return res.json();
    })
    .then((blob) => {
      // Save an ID if it is provided.
      if (blob.hasOwnProperty("new_id")) {
        console.log("setPageViewCounts: Got new ID from server. Saving...");
        localStorage.setItem("rcf_user_id", blob.new_id);
      }

      // Set the page views if they are given by the server.
      if (blob.hasOwnProperty("page_views")) {
        setPageViews(blob.page_views.toString());
      }
    })
    .catch((e) => {
      // This feature is still in development, so no worries if errors occur.
      console.error("setPageViewCounts: POST failed.");
      console.error(e);
    });
}

/**
 * Looks for views element and sets inner text/makes visible.
 * @param {string} message Will be placed in the view counter
 */
function setPageViews(message) {
  var count = document.getElementById("views");
  var box = document.getElementById("views-box");

  // If one or the other of the elements is not present, return.
  if (!box || !count) return;

  // Otherwise, set the number and make it visible.
  count.innerText = message;
  box.classList.remove("invisible");
  box.classList.add("visible");
}

/**
 * Checks if being served from localhost and returns proper backend URL.
 * @returns {string} The URL for the backend.
 */
function getServerUrl() {
  var url = window.location.href.toString();
  var server = "https://rcf-services.herokuapp.com";

  // If running in development, point requests to localhost:8000
  if (url.indexOf("localhost") == 7) {
    console.log("getServerUrl: In development mode, using local backend.");
    server = "http://localhost:8000";
  }

  return server;
}

/*
 * On load operation. Calls a number of functions once the DOM is ready.
 * All features should be called in this block.
 */
window.addEventListener("load", function (event) {
  // Feature functions:
  addAnchorsToHeaders();
  // setPageViewCounts();
});
