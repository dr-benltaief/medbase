TEMPLATE = app
TARGET = medbase
INCLUDEPATH += .

win32 {
	RC_FILE = windows/windows.rc
}

unix:!macx {
	target.path = /usr/share/medbase/
	shortcutfiles.files += linux/medbase.desktop
	shortcutfiles.path = /usr/share/applications/
	data.files = linux/medbase.png
	data.path = /usr/share/pixmaps/
	INSTALLS += target
	INSTALLS += shortcutfiles
	INSTALLS += data
}

macx: {
	ICON = macx/medbase.icns
}

SOURCES += medbase.cpp
QT += webkitwidgets
RESOURCES += medbase.qrc