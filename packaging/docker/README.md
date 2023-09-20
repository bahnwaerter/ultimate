# Package Ultimate for Docker

## Build Ultimate Docker images
An Ultimate `PRODUCT` can be built with the following Docker call

```shell
docker build -t <PRODUCT> --target <PRODUCT> .
```

where `PRODUCT` is a placeholder for one of the products

  - `ultimate-cli`
  - `ultimate-debug`
  - `ultimate-reqanalyzer`
  - `ultimate-deltadebugger`
  - `ultimate-eliminator`
  - `ultimate-webbackend`
  - `ultimate-websitestatic`

shipped with the Ultimate program analysis framework.

For validating the built Ultimate `PRODUCT` image, you can create and run a Docker container based on this image with the following Docker call.
```shell
docker run -it <PRODUCT>
```
As an expected result, you should then receive the Ultimate version output from the executed Ultimate `PRODUCT` in the container.


## Run Ultimate Docker containers

If you want to run Ultimate interactively for any verification input, you can spwan a bash in a created and started Ultimate `PRODUCT` container as follows.
```shell
docker run -it <PRODUCT> /bin/bash
<PRODUCT> -tc <TOOLCHAIN> -s <SETTINGS> -i <PROGRAM>
```
Calling the Ultimate `PRODUCT` within the container then follows as usual, where a `TOOLCHAIN`, `SETTINGS`, and `PROGRAM` file path should be specified for a verification run.
An exception is a start of the graphical Ultimate Debug UI.
To do this, a graphic connection to the host system must be established via the X11 protocol, which can be done with the following Docker call.
```shell
docker run -it --network host \
           -e DISPLAY=$DISPLAY \
           -v <XAUTHORITY>:/home/build/ultimate/.Xauthority \
           -v /tmp/.X11-unix:/tmp/.X11-unix \
           ultimate-debug
```
Note that the Docker call requires an `XAUTHORITY` file from the host system to grant the Ultimate Debug UI in the Docker container access to the graphical session on the host.
An `XAUTHORITY` file is, in the case of an X11 session, often located in the user's home directory on the host system and usually named `.Xauthority`.
In the case of a Wayland session, the `XAUTHORITY` file is often located under `/run/user/*/.*Xwaylandauth*`.
The `XAUTHORITY` file is mounted into the container by Docker along with a temporary Unix X11 socket to establish an X11 connection between host and container.
The Ultimate Debug UI application then uses this connection to render its graphical interface outside of the container on the host system.


## Configure Ultimate Webbackend

The specific Ultimate `PRODUCT` called `ultimate-webbackend` requires an extensive and valid configuration for the Web service to start.
It is recommended to deploy the Ultimate WebBackend using `docker-compose` while the standard configuration for this service should be adjusted.
The service can be configured by customizing the following environment variables in the `ultimate-webbackend.env` environment configuration file.
```
# backend settings
ULTIMATE_BACKEND_HOST=localhost
ULTIMATE_BACKEND_PORT=8080
ULTIMATE_BACKEND_ROUTE=/api
ULTIMATE_BACKEND_START_TIMEOUT=30

# frontend settings
ULTIMATE_FRONTEND_SERVE=False
ULTIMATE_FRONTEND_PATH=/some/path
ULTIMATE_FRONTEND_ROUTE=/website

# log settings
ULTIMATE_LOG_PATH=/dev/stdout
ULTIMATE_LOG_LEVEL=INFO

# general settings
ULTIMATE_DIR_TMP=/tmp/ultimate
ULTIMATE_TIMEOUT=90
```
A description of each variable and its valid values is documented in the configuration file template `web.config.properties.tpl`.
If the Ultimate Webbackend service is configured properly one can build and start the service with the following `docker-compose` call.
```shell
docker compose up --build
```
