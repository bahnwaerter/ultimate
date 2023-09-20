server {
    listen      {{ .Env.ULTIMATE_FRONTEND_PORT }};
    listen [::]:{{ .Env.ULTIMATE_FRONTEND_PORT }};
    server_name {{ .Env.ULTIMATE_FRONTEND_HOST }};

    location / {
        root   {{ .Env.ULTIMATE_FRONTEND_ROOT_DIR }};
        index  index.html;
    }

    error_page 500 502 503 504 /50x.html;
    location = /50x.html {
        root   /usr/share/nginx/html;
    }

    error_page 404 /404.html;
    location /404.html {
        root {{ .Env.ULTIMATE_FRONTEND_ROOT_DIR }};
        internal;
    }
}
