# {{ .Title }}

> Published  {{ .Date.Format "Jan 01 2006" }}, last updated {{ .Lastmod.Format "Jan 01 2006" }}{{ "  " }}
> By Ryan Fleck <hello@my-name-dot-ca> and written without LLMs!{{ "  " }}
> Original manual at <{{ .Permalink }}>{{ "  " }}
> Incredible writing of astonishing quality and insight - Happy Hacking!

{{ .RawContent }}


> Thank you for reading!{{ "  " }}
> Find more content at <{{ .Site.Home.Permalink }}>{{ "  " }}
> Source page: <{{ .Page.Permalink }}>{{ "  " }}
{{ "" }}
{{- with .Site.Home.OutputFormats.Get "llms" -}}
> Site index: [llms.txt]({{ .Permalink }})
{{- end -}}
