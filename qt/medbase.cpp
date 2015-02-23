#include <QApplication>
#include <QWebView>
#include <QWebFrame>
#include <QDesktopWidget>
#include <QObject>

class QtInterface: public QObject
{
	Q_OBJECT
public slots:
	Q_INVOKABLE QString search(int method, QString terms) {

		QString answer = "Interface Qt / ";

		if (method == 1) {
			// Recherche simple
			answer += "Recherche simple / "+terms;
		} else {
			// Recherche avancée
			answer += "Recherche avancée / "+terms;
		}
	return answer;
	}
};

int main(int argc, char **argv)
{
	QApplication app(argc, argv);
	QWebView *view = new QWebView();

	view->resize(480,600);
	view->setMinimumSize(480,600);
	QRect screenGeometry = QApplication::desktop()->screenGeometry();
	int x = (screenGeometry.width()-480) / 2;
	int y = (screenGeometry.height()-600) / 2;
	view->move(x, y);

	view->setContextMenuPolicy(Qt::PreventContextMenu);
	view->settings()->setAttribute(QWebSettings::LocalContentCanAccessRemoteUrls,1);
	view->page()->mainFrame()->addToJavaScriptWindowObject(QString("Qt"), new QtInterface);

	view->load(QUrl("qrc:/index.html"));
	view->setWindowTitle("MedBase");
	view->show();

	return app.exec();
}

#include "medbase.moc"