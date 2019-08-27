from rest_framework import serializers
from swimdiary.models import *
from django.contrib.auth.models import User


class UserSerializer(serializers.ModelSerializer):
    notes = serializers.PrimaryKeyRelatedField(many=True, queryset=Note.objects.all())
    seasons = serializers.PrimaryKeyRelatedField(many=True, queryset=Season.objects.all())
    periods = serializers.PrimaryKeyRelatedField(many=True, queryset=Period.objects.all())
    weeks = serializers.PrimaryKeyRelatedField(many=True, queryset=Week.objects.all())
    trainings = serializers.PrimaryKeyRelatedField(many=True, queryset=Training.objects.all())
    tasks = serializers.PrimaryKeyRelatedField(many=True, queryset=Task.objects.all())

    class Meta:
        model = User
        fields = ['id', 'username', 'email', 'notes', 'seasons', 'periods', 'weeks', 'trainings', 'tasks']


class NoteSerializer(serializers.ModelSerializer):
    created_by = serializers.ReadOnlyField(source='created_by.username')

    class Meta:
        model = Note
        fields = ['id', 'text', 'created_by']


class TypeSerializer(serializers.ModelSerializer):
    class Meta:
        model = Type
        fields = ['id', 'name']


class SeasonSerializer(serializers.ModelSerializer):
    # periods = serializers.PrimaryKeyRelatedField(many=True, queryset=Period.objects.all())
    created_by = serializers.ReadOnlyField(source='created_by.username')

    class Meta:
        model = Season
        fields = ['id', 'name', 'year',  'created_by']


class PeriodSerializer(serializers.ModelSerializer):
    # weeks = serializers.PrimaryKeyRelatedField(many=True, queryset=Week.objects.all())
    created_by = serializers.ReadOnlyField(source='created_by.username')

    class Meta:
        model = Period
        fields = ['id', 'note', 'type', 'season', 'weeks', 'created_by']


class WeekSerializer(serializers.ModelSerializer):
    # note = NoteSerializer()
    # trainings = serializers.PrimaryKeyRelatedField(many=True, queryset=Training.objects.all())
    created_by = serializers.ReadOnlyField(source='created_by.username')

    # treba implementirati svoju create metodu jer kod izrade tjedna se rade i note-ovi
    # type treba biti prethodno napravljen pa se prilikom izrade odabere tip

    class Meta:
        model = Week
        fields = ['id', 'length', 'ordinal', 'note', 'type', 'trainings', 'created_by']


class TrainingSerializer(serializers.ModelSerializer):
    # tasks = serializers.PrimaryKeyRelatedField(many=True, queryset=Task.objects.all())
    created_by = serializers.ReadOnlyField(source='created_by.username')

    class Meta:
        model = Training
        fields = ['id', 'length', 'date', 'note', 'type', 'week', 'tasks', 'created_by']


class TaskSerializer(serializers.ModelSerializer):
    created_by = serializers.ReadOnlyField(source='created_by.username')

    class Meta:
        model = Task
        fields = ['id', 'title', 'fins', 'paddles', 'snorkel', 'plane',
                  'board', 'rubber', 'note', 'type', 'training', 'created_by']

# moram odlucit, najmanje prema najvecem ili obrnuto