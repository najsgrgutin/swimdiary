from django.db import models

# sezona se sastoji od n perioda koji se mogu ponavljati
# svaki period ima n tjedana
# svaki tjedan ima 11 treninga
# svaki trening se sastoji od n zadataka

# opcionalno kod izrade perioda, tjedna, treninga i zadatka
class Note(models.Model):
    text = models.CharField(max_length=100)

    class Meta:
        db_table = 'Note'

# obavezno kod izrade perioda
# opcionalno kod izrade tjedna, treninga i zadatka
class Type(models.Model):
    name = models.CharField(max_length=20)

    class Meta:
        db_table = 'Type'


class Season(models.Model):
    name = models.CharField(max_length=50, null=True, blank=False)
    year = models.CharField(max_length=20)

    class Meta:
        db_table = 'Season'


class Period(models.Model):
    note = models.ForeignKey(Note, on_delete=models.PROTECT, null=True, blank=True)
    type = models.ForeignKey(Type, on_delete=models.PROTECT)
    season = models.ForeignKey(Season, on_delete=models.PROTECT)

    class Meta:
        db_table = 'Period'


class Week(models.Model):
    length = models.FloatField()
    ordinal = models.IntegerField()
    note = models.ForeignKey(Note, on_delete=models.PROTECT, null=True, blank=True)
    type = models.ForeignKey(Type, on_delete=models.PROTECT, null=True, blank=True)
    period = models.ForeignKey(Period, on_delete=models.CASCADE)

    class Meta:
        db_table = 'Week'


class Training(models.Model):
    date = models.DateField()
    length = models.FloatField()
    note = models.ForeignKey(Note, on_delete=models.PROTECT, null=True, blank=True)
    type = models.ForeignKey(Type, on_delete=models.PROTECT, null=True, blank=True)
    week = models.ForeignKey(Week, on_delete=models.CASCADE, default='')

    class Meta:
        db_table = 'Training'


class Task(models.Model):
    title = models.TextField()
    note = models.ForeignKey(Note, on_delete=models.PROTECT, null=True, blank=True)
    type = models.ForeignKey(Type, on_delete=models.PROTECT, null=True, blank=True)
    training = models.ForeignKey(Training, on_delete=models.PROTECT, default='')
    fins = models.BooleanField()
    paddles = models.BooleanField()
    snorkel = models.BooleanField()
    plane = models.BooleanField()
    board = models.BooleanField()
    rubber = models.BooleanField()

    class Meta:
        db_table = 'Task'
