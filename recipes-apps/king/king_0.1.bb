SUMMARY = "An example applications with Python"
DESCRIPTION = "created by Lukas da Rosa lukas-sr @ hotmail.com"
LICENSE = "CLOSED"
#Runtime depends of <package>; Do not mistake with the function DEPENDS_${PN}, build dependention
RDEPENDS_${PN} += "python3-core"

SRC_URI += " file://king.py \
	         file://king.service \
	       "

inherit systemd

do_install(){
	install -d ${D}${bindir}
	install -m 0755 ${WORKDIR}/king.py ${D}${bindir}

	install -d ${D}${systemd_unitdir}/system
	install -m 0644 ${WORKDIR}/king.service ${D}${systemd_unitdir}/system
}

FILES_${PN} += "/home/root"
FILES_${PN} += "/lib/systemd/system"

SYSTEMD_SERVICE_${PN} = "king.service"
SYSTEMD_AUTO_ENABLE ??= "enable"
