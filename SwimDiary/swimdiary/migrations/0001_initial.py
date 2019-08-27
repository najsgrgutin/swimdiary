# Generated by Django 2.2.4 on 2019-08-26 15:34

from django.conf import settings
from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    initial = True

    dependencies = [
        migrations.swappable_dependency(settings.AUTH_USER_MODEL),
    ]

    operations = [
        migrations.CreateModel(
            name='Note',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('text', models.CharField(max_length=100)),
                ('created_by', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, related_name='notes', to=settings.AUTH_USER_MODEL)),
            ],
            options={
                'db_table': 'Note',
            },
        ),
        migrations.CreateModel(
            name='Period',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('ordinal', models.IntegerField()),
                ('created_by', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, related_name='periods', to=settings.AUTH_USER_MODEL)),
                ('note', models.ForeignKey(blank=True, null=True, on_delete=django.db.models.deletion.CASCADE, to='swimdiary.Note')),
            ],
            options={
                'db_table': 'Period',
            },
        ),
        migrations.CreateModel(
            name='Type',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('name', models.CharField(max_length=20)),
            ],
            options={
                'db_table': 'Type',
            },
        ),
        migrations.CreateModel(
            name='Week',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('length', models.FloatField()),
                ('ordinal', models.IntegerField()),
                ('created_by', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, related_name='weeks', to=settings.AUTH_USER_MODEL)),
                ('note', models.ForeignKey(blank=True, null=True, on_delete=django.db.models.deletion.CASCADE, to='swimdiary.Note')),
                ('period', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='swimdiary.Period')),
                ('type', models.ForeignKey(blank=True, null=True, on_delete=django.db.models.deletion.PROTECT, to='swimdiary.Type')),
            ],
            options={
                'db_table': 'Week',
            },
        ),
        migrations.CreateModel(
            name='Training',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('date', models.DateField()),
                ('length', models.FloatField()),
                ('created_by', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, related_name='trainings', to=settings.AUTH_USER_MODEL)),
                ('note', models.ForeignKey(blank=True, null=True, on_delete=django.db.models.deletion.CASCADE, to='swimdiary.Note')),
                ('type', models.ForeignKey(blank=True, null=True, on_delete=django.db.models.deletion.PROTECT, to='swimdiary.Type')),
                ('week', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='swimdiary.Week')),
            ],
            options={
                'db_table': 'Training',
            },
        ),
        migrations.CreateModel(
            name='Task',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('title', models.TextField()),
                ('fins', models.BooleanField()),
                ('paddles', models.BooleanField()),
                ('snorkel', models.BooleanField()),
                ('plane', models.BooleanField()),
                ('board', models.BooleanField()),
                ('rubber', models.BooleanField()),
                ('created_by', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, related_name='tasks', to=settings.AUTH_USER_MODEL)),
                ('note', models.ForeignKey(blank=True, null=True, on_delete=django.db.models.deletion.CASCADE, to='swimdiary.Note')),
                ('training', models.ForeignKey(on_delete=django.db.models.deletion.PROTECT, to='swimdiary.Training')),
                ('type', models.ForeignKey(blank=True, null=True, on_delete=django.db.models.deletion.PROTECT, to='swimdiary.Type')),
            ],
            options={
                'db_table': 'Task',
            },
        ),
        migrations.CreateModel(
            name='Season',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('name', models.CharField(max_length=50, null=True)),
                ('year', models.CharField(max_length=20)),
                ('created_by', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, related_name='seasons', to=settings.AUTH_USER_MODEL)),
            ],
            options={
                'db_table': 'Season',
            },
        ),
        migrations.AddField(
            model_name='period',
            name='season',
            field=models.ForeignKey(on_delete=django.db.models.deletion.PROTECT, to='swimdiary.Season'),
        ),
        migrations.AddField(
            model_name='period',
            name='type',
            field=models.ForeignKey(on_delete=django.db.models.deletion.PROTECT, to='swimdiary.Type'),
        ),
    ]
