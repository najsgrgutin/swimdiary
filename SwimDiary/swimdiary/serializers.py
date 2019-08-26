from rest_framework import serializers
from swimdiary.models import *


class NoteSerializer(serializers.ModelSerializer):
    class Meta:
        model = Note
        fields = ['id', 'text']


class TypeSerializer(serializers.ModelSerializer):
    class Meta:
        model = Type
        fields = ['id', 'name']


class SeasonSerializer(serializers.ModelSerializer):
    periods = serializers.PrimaryKeyRelatedField(many=True, queryset=Period.objects.all())

    class Meta:
        model = Season
        fields = ['id', 'name', 'year', 'periods']


class PeriodSerializer(serializers.ModelSerializer):
    weeks = serializers.PrimaryKeyRelatedField(many=True, queryset=Week.objects.all())

    class Meta:
        model = Period
        fields = ['id', 'note', 'type', 'season', 'weeks']


class WeekSerializer(serializers.ModelSerializer):
    # note = NoteSerializer()
    trainings = serializers.PrimaryKeyRelatedField(many=True, queryset=Training.objects.all())
    # treba implementirati svoju create metodu jer kod izrade tjedna se rade i note-ovi
    # type treba biti prethodno napravljen pa se prilikom izrade odabere tip

    class Meta:
        model = Week
        fields = ['id', 'length', 'ordinal', 'note', 'type', 'trainings']


class TrainingSerializer(serializers.ModelSerializer):
    tasks = serializers.PrimaryKeyRelatedField(many=True, queryset=Task.objects.all())

    class Meta:
        model = Training
        fields = ['id', 'length', 'date', 'note', 'type', 'week', 'tasks']


class TaskSerializer(serializers.ModelSerializer):
    class Meta:
        model = Task
        fields = ['id', 'title', 'fins', 'paddles', 'snorkel', 'plane', 'board', 'rubber', 'note', 'type', 'training']
