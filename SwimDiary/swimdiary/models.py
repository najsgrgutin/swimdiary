from django.db import models


class Note(models.Model):
    text = models.CharField(max_length=100)
    created_by = models.ForeignKey('auth.User', related_name='notes', on_delete=models.CASCADE)

    class Meta:
        db_table = 'Note'


class Type(models.Model):
    name = models.CharField(max_length=20)

    class Meta:
        db_table = 'Type'


class Season(models.Model):
    name = models.CharField(max_length=50, null=True, blank=False)
    year = models.CharField(max_length=20)
    created_by = models.ForeignKey('auth.User', related_name='seasons', on_delete=models.CASCADE)

    class Meta:
        db_table = 'Season'


class Period(models.Model):
    note = models.ForeignKey(Note, on_delete=models.CASCADE, null=True, blank=True)
    type = models.ForeignKey(Type, on_delete=models.PROTECT)
    season = models.ForeignKey(Season, on_delete=models.PROTECT)
    ordinal = models.IntegerField()
    created_by = models.ForeignKey('auth.User', related_name='periods', on_delete=models.CASCADE)

    class Meta:
        db_table = 'Period'


class Week(models.Model):
    length = models.FloatField()
    ordinal = models.IntegerField()
    note = models.ForeignKey(Note, on_delete=models.CASCADE, null=True, blank=True)
    type = models.ForeignKey(Type, on_delete=models.PROTECT, null=True, blank=True)
    period = models.ForeignKey(Period, on_delete=models.CASCADE)
    created_by = models.ForeignKey('auth.User', related_name='weeks', on_delete=models.CASCADE)

    class Meta:
        db_table = 'Week'


class Training(models.Model):
    date = models.DateField()
    length = models.FloatField()
    note = models.ForeignKey(Note, on_delete=models.CASCADE, null=True, blank=True)
    type = models.ForeignKey(Type, on_delete=models.PROTECT, null=True, blank=True)
    week = models.ForeignKey(Week, on_delete=models.CASCADE)
    created_by = models.ForeignKey('auth.User', related_name='trainings', on_delete=models.CASCADE)

    class Meta:
        db_table = 'Training'


class Task(models.Model):
    title = models.TextField()
    note = models.ForeignKey(Note, on_delete=models.CASCADE, null=True, blank=True)
    type = models.ForeignKey(Type, on_delete=models.PROTECT, null=True, blank=True)
    training = models.ForeignKey(Training, on_delete=models.PROTECT)
    created_by = models.ForeignKey('auth.User', related_name='tasks', on_delete=models.CASCADE)
    fins = models.BooleanField()
    paddles = models.BooleanField()
    snorkel = models.BooleanField()
    plane = models.BooleanField()
    board = models.BooleanField()
    rubber = models.BooleanField()

    class Meta:
        db_table = 'Task'
