# Generated by Django 2.2.4 on 2019-08-20 12:42

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('swimdiary', '0002_auto_20190820_0913'),
    ]

    operations = [
        migrations.AlterField(
            model_name='training',
            name='date',
            field=models.DateField(),
        ),
    ]
