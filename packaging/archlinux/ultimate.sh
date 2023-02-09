#!/bin/sh
TOOL=
exec archlinux-java-run --min 11 --max 11 -- -jar /opt/ultimate/${TOOL}/plugins/org.eclipse.equinox.launcher_1.5.800.v20200727-1323.jar ${@}
