from rest_framework import generics, permissions
from swimdiary.serializers import *


class UserList(generics.ListAPIView):
    queryset = User.objects.all()
    serializer_class = UserSerializer


class UserDetail(generics.RetrieveAPIView):
    queryset = User.objects.all()
    serializer_class = UserSerializer


# Note classes
class NoteList(generics.ListCreateAPIView):
    permission_classes = [permissions.IsAuthenticatedOrReadOnly]
    queryset = Note.objects.all()
    serializer_class = NoteSerializer

    # metoda pomocu koje eksplicitno kazemo da treba spremiti usera u polje created_by
    def perform_create(self, serializer):
        serializer.save(created_by=self.request.user)


class NoteDetail(generics.RetrieveUpdateDestroyAPIView):
    permission_classes = [permissions.IsAuthenticatedOrReadOnly]
    queryset = Note.objects.all()
    serializer_class = NoteSerializer


# Type classes
class TypeList(generics.ListCreateAPIView):
    queryset = Type.objects.all()
    serializer_class = TypeSerializer


class TypeDetail(generics.RetrieveUpdateDestroyAPIView):
    queryset = Type.objects.all()
    serializer_class = TypeSerializer


# Season classes
class SeasonList(generics.ListCreateAPIView):
    permission_classes = [permissions.IsAuthenticatedOrReadOnly]
    queryset = Season.objects.all()
    serializer_class = SeasonSerializer

    def perform_create(self, serializer):
        serializer.save(created_by=self.request.user)


class SeasonDetail(generics.RetrieveUpdateDestroyAPIView):
    permission_classes = [permissions.IsAuthenticatedOrReadOnly]
    queryset = Season.objects.all()
    serializer_class = SeasonSerializer


# Period classes
class PeriodList(generics.ListCreateAPIView):
    permission_classes = [permissions.IsAuthenticatedOrReadOnly]
    queryset = Period.objects.all()
    serializer_class = PeriodSerializer

    def perform_create(self, serializer):
        serializer.save(created_by=self.request.user)


class PeriodDetail(generics.RetrieveUpdateDestroyAPIView):
    permission_classes = [permissions.IsAuthenticatedOrReadOnly]
    queryset = Period.objects.all()
    serializer_class = PeriodSerializer


# Week classes
class WeekList(generics.ListCreateAPIView):
    permission_classes = [permissions.IsAuthenticatedOrReadOnly]
    queryset = Week.objects.all()
    serializer_class = WeekSerializer

    def perform_create(self, serializer):
        serializer.save(created_by=self.request.user)


class WeekDetail(generics.RetrieveUpdateDestroyAPIView):
    permission_classes = [permissions.IsAuthenticatedOrReadOnly]
    queryset = Week.objects.all()
    serializer_class = WeekSerializer


# Training classes
class TrainingList(generics.ListCreateAPIView):
    permission_classes = [permissions.IsAuthenticatedOrReadOnly]
    queryset = Training.objects.all()
    serializer_class = TrainingSerializer

    def perform_create(self, serializer):
        serializer.save(created_by=self.request.user)


class TrainingDetail(generics.RetrieveUpdateDestroyAPIView):
    permission_classes = [permissions.IsAuthenticatedOrReadOnly]
    queryset = Training.objects.all()
    serializer_class = TrainingSerializer


# Task classes
class TaskList(generics.ListCreateAPIView):
    permission_classes = [permissions.IsAuthenticatedOrReadOnly]
    queryset = Task.objects.all()
    serializer_class = TaskSerializer

    def perform_create(self, serializer):
        serializer.save(created_by=self.request.user)


class TaskDetail(generics.RetrieveUpdateDestroyAPIView):
    permission_classes = [permissions.IsAuthenticatedOrReadOnly]
    queryset = Task.objects.all()
    serializer_class = TaskSerializer
