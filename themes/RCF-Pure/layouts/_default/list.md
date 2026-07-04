# {{ .Title }}

> {{ .Summary | plainify | truncate 500 }}
{{ " " }}
{{- range .RegularPagesRecursive }}
{{- if or (not .Params.Hidden) (and .Params.Hidden (not hugo.IsProduction)) }}
- [{{ .Title }}]({{ .Permalink }}index.md)
{{- end -}}
{{- end }}

Source page: {{ .Page.Permalink }}
{{ "" }}
{{- with .Site.Home.OutputFormats.Get "llms" -}}
Site index: [llms.txt]({{ .Permalink }})
{{- end -}}
