/********************************************************************************
** Form generated from reading UI file 'mainwindow.ui'
**
** Created by: Qt User Interface Compiler version 5.12.8
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_MAINWINDOW_H
#define UI_MAINWINDOW_H

#include <QtCore/QVariant>
#include <QtWidgets/QApplication>
#include <QtWidgets/QCheckBox>
#include <QtWidgets/QComboBox>
#include <QtWidgets/QHBoxLayout>
#include <QtWidgets/QLabel>
#include <QtWidgets/QLineEdit>
#include <QtWidgets/QMainWindow>
#include <QtWidgets/QMenuBar>
#include <QtWidgets/QPushButton>
#include <QtWidgets/QRadioButton>
#include <QtWidgets/QSpacerItem>
#include <QtWidgets/QStatusBar>
#include <QtWidgets/QVBoxLayout>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_MainWindow
{
public:
    QWidget *centralwidget;
    QVBoxLayout *verticalLayout_4;
    QHBoxLayout *horizontalLayout;
    QLabel *label;
    QLineEdit *lineEdit;
    QSpacerItem *verticalSpacer;
    QVBoxLayout *verticalLayout;
    QLabel *label_2;
    QCheckBox *checkBox_2;
    QCheckBox *checkBox;
    QCheckBox *checkBox_3;
    QCheckBox *checkBox_4;
    QCheckBox *checkBox_5;
    QSpacerItem *verticalSpacer_2;
    QVBoxLayout *verticalLayout_2;
    QLabel *label_3;
    QRadioButton *radioButton;
    QRadioButton *radioButton_2;
    QSpacerItem *verticalSpacer_3;
    QVBoxLayout *verticalLayout_3;
    QLabel *label_4;
    QComboBox *comboBox;
    QSpacerItem *verticalSpacer_4;
    QPushButton *pushButton;
    QMenuBar *menubar;
    QStatusBar *statusbar;

    void setupUi(QMainWindow *MainWindow)
    {
        if (MainWindow->objectName().isEmpty())
            MainWindow->setObjectName(QString::fromUtf8("MainWindow"));
        MainWindow->resize(430, 580);
        centralwidget = new QWidget(MainWindow);
        centralwidget->setObjectName(QString::fromUtf8("centralwidget"));
        verticalLayout_4 = new QVBoxLayout(centralwidget);
        verticalLayout_4->setObjectName(QString::fromUtf8("verticalLayout_4"));
        horizontalLayout = new QHBoxLayout();
        horizontalLayout->setObjectName(QString::fromUtf8("horizontalLayout"));
        label = new QLabel(centralwidget);
        label->setObjectName(QString::fromUtf8("label"));
        QFont font;
        font.setFamily(QString::fromUtf8("Arial"));
        font.setPointSize(10);
        label->setFont(font);

        horizontalLayout->addWidget(label);

        lineEdit = new QLineEdit(centralwidget);
        lineEdit->setObjectName(QString::fromUtf8("lineEdit"));
        lineEdit->setFont(font);

        horizontalLayout->addWidget(lineEdit);


        verticalLayout_4->addLayout(horizontalLayout);

        verticalSpacer = new QSpacerItem(20, 40, QSizePolicy::Minimum, QSizePolicy::Expanding);

        verticalLayout_4->addItem(verticalSpacer);

        verticalLayout = new QVBoxLayout();
        verticalLayout->setObjectName(QString::fromUtf8("verticalLayout"));
        label_2 = new QLabel(centralwidget);
        label_2->setObjectName(QString::fromUtf8("label_2"));
        QFont font1;
        font1.setFamily(QString::fromUtf8("Arial"));
        font1.setPointSize(10);
        font1.setBold(true);
        font1.setWeight(75);
        label_2->setFont(font1);

        verticalLayout->addWidget(label_2);

        checkBox_2 = new QCheckBox(centralwidget);
        checkBox_2->setObjectName(QString::fromUtf8("checkBox_2"));
        checkBox_2->setFont(font);

        verticalLayout->addWidget(checkBox_2);

        checkBox = new QCheckBox(centralwidget);
        checkBox->setObjectName(QString::fromUtf8("checkBox"));
        checkBox->setFont(font);

        verticalLayout->addWidget(checkBox);

        checkBox_3 = new QCheckBox(centralwidget);
        checkBox_3->setObjectName(QString::fromUtf8("checkBox_3"));
        checkBox_3->setFont(font);

        verticalLayout->addWidget(checkBox_3);

        checkBox_4 = new QCheckBox(centralwidget);
        checkBox_4->setObjectName(QString::fromUtf8("checkBox_4"));
        checkBox_4->setFont(font);

        verticalLayout->addWidget(checkBox_4);

        checkBox_5 = new QCheckBox(centralwidget);
        checkBox_5->setObjectName(QString::fromUtf8("checkBox_5"));
        checkBox_5->setFont(font);

        verticalLayout->addWidget(checkBox_5);


        verticalLayout_4->addLayout(verticalLayout);

        verticalSpacer_2 = new QSpacerItem(20, 40, QSizePolicy::Minimum, QSizePolicy::Expanding);

        verticalLayout_4->addItem(verticalSpacer_2);

        verticalLayout_2 = new QVBoxLayout();
        verticalLayout_2->setObjectName(QString::fromUtf8("verticalLayout_2"));
        label_3 = new QLabel(centralwidget);
        label_3->setObjectName(QString::fromUtf8("label_3"));
        label_3->setFont(font1);

        verticalLayout_2->addWidget(label_3);

        radioButton = new QRadioButton(centralwidget);
        radioButton->setObjectName(QString::fromUtf8("radioButton"));
        radioButton->setFont(font);

        verticalLayout_2->addWidget(radioButton);

        radioButton_2 = new QRadioButton(centralwidget);
        radioButton_2->setObjectName(QString::fromUtf8("radioButton_2"));
        radioButton_2->setFont(font);

        verticalLayout_2->addWidget(radioButton_2);


        verticalLayout_4->addLayout(verticalLayout_2);

        verticalSpacer_3 = new QSpacerItem(20, 40, QSizePolicy::Minimum, QSizePolicy::Expanding);

        verticalLayout_4->addItem(verticalSpacer_3);

        verticalLayout_3 = new QVBoxLayout();
        verticalLayout_3->setObjectName(QString::fromUtf8("verticalLayout_3"));
        label_4 = new QLabel(centralwidget);
        label_4->setObjectName(QString::fromUtf8("label_4"));
        label_4->setFont(font1);

        verticalLayout_3->addWidget(label_4);

        comboBox = new QComboBox(centralwidget);
        comboBox->addItem(QString());
        comboBox->addItem(QString());
        comboBox->addItem(QString());
        comboBox->addItem(QString());
        comboBox->addItem(QString());
        comboBox->setObjectName(QString::fromUtf8("comboBox"));
        comboBox->setFont(font);

        verticalLayout_3->addWidget(comboBox);


        verticalLayout_4->addLayout(verticalLayout_3);

        verticalSpacer_4 = new QSpacerItem(20, 40, QSizePolicy::Minimum, QSizePolicy::Expanding);

        verticalLayout_4->addItem(verticalSpacer_4);

        pushButton = new QPushButton(centralwidget);
        pushButton->setObjectName(QString::fromUtf8("pushButton"));
        QFont font2;
        font2.setFamily(QString::fromUtf8("Arial"));
        font2.setPointSize(12);
        font2.setBold(false);
        font2.setItalic(false);
        font2.setWeight(50);
        pushButton->setFont(font2);

        verticalLayout_4->addWidget(pushButton);

        MainWindow->setCentralWidget(centralwidget);
        menubar = new QMenuBar(MainWindow);
        menubar->setObjectName(QString::fromUtf8("menubar"));
        menubar->setGeometry(QRect(0, 0, 430, 19));
        MainWindow->setMenuBar(menubar);
        statusbar = new QStatusBar(MainWindow);
        statusbar->setObjectName(QString::fromUtf8("statusbar"));
        MainWindow->setStatusBar(statusbar);

        retranslateUi(MainWindow);

        QMetaObject::connectSlotsByName(MainWindow);
    } // setupUi

    void retranslateUi(QMainWindow *MainWindow)
    {
        MainWindow->setWindowTitle(QApplication::translate("MainWindow", "MainWindow", nullptr));
        label->setText(QApplication::translate("MainWindow", "\320\222\320\260\321\210\320\265 \320\270\320\274\321\217", nullptr));
        label_2->setText(QApplication::translate("MainWindow", "1. \320\232\320\260\320\272\320\270\320\265 \321\201\321\203\321\211\320\265\321\201\321\202\320\262\321\203\321\216\321\202 \321\201\321\205\320\265\320\274\321\213 \321\200\320\260\320\267\320\274\320\265\321\211\320\265\320\275\320\270\321\217?", nullptr));
        checkBox_2->setText(QApplication::translate("MainWindow", "\320\222\320\265\321\200\321\202\320\270\320\272\320\260\320\273\321\214\320\275\320\260\321\217", nullptr));
        checkBox->setText(QApplication::translate("MainWindow", "\320\223\320\276\321\200\320\270\320\267\320\276\320\275\321\202\320\260\320\273\321\214\320\275\320\260\321\217", nullptr));
        checkBox_3->setText(QApplication::translate("MainWindow", "\320\241\320\265\321\202\320\276\321\207\320\275\320\260\321\217", nullptr));
        checkBox_4->setText(QApplication::translate("MainWindow", "\320\241\321\205\320\265\320\274\320\260 \321\204\320\276\321\200\320\274\321\213", nullptr));
        checkBox_5->setText(QApplication::translate("MainWindow", "\320\235\320\265 \321\201\321\203\321\211\320\265\321\201\321\202\320\262\321\203\320\265\321\202 \321\201\321\205\320\265\320\274", nullptr));
        label_3->setText(QApplication::translate("MainWindow", "2. \320\234\320\276\320\266\320\275\320\276 \320\273\320\270 \321\201\320\276\320\267\320\264\320\260\320\262\320\260\321\202\321\214 \321\204\320\276\321\200\320\274\321\203 \320\275\320\260\320\277\321\200\321\217\320\274\321\203\321\216 \320\270\320\267 \320\272\320\276\320\264\320\260?", nullptr));
        radioButton->setText(QApplication::translate("MainWindow", "\320\224\320\260", nullptr));
        radioButton_2->setText(QApplication::translate("MainWindow", "\320\235\320\265\321\202", nullptr));
        label_4->setText(QApplication::translate("MainWindow", "3. \320\232\320\260\320\272\320\276\320\271 \321\215\320\273\320\265\320\274\320\265\320\275\321\202 \320\277\320\276\320\264\321\205\320\276\320\264\320\270\321\202 \320\264\320\273\321\217 \320\262\320\262\320\276\320\264\320\260 \321\202\320\265\320\272\321\201\321\202\320\260?", nullptr));
        comboBox->setItemText(0, QApplication::translate("MainWindow", "Text Box", nullptr));
        comboBox->setItemText(1, QApplication::translate("MainWindow", "Line Edit", nullptr));
        comboBox->setItemText(2, QApplication::translate("MainWindow", "Combo Box", nullptr));
        comboBox->setItemText(3, QApplication::translate("MainWindow", "Label", nullptr));
        comboBox->setItemText(4, QApplication::translate("MainWindow", "Time Edit", nullptr));

        pushButton->setText(QApplication::translate("MainWindow", "\320\236\321\202\320\277\321\200\320\260\320\262\320\270\321\202\321\214", nullptr));
    } // retranslateUi

};

namespace Ui {
    class MainWindow: public Ui_MainWindow {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_MAINWINDOW_H
