from django.urls import path
from swimdiary import views

urlpatterns = [
    path('notes/', views.NoteList.as_view()),
    path('notes/<int:pk>/', views.NoteDetail.as_view()),
    path('types/', views.TypeList.as_view()),
    path('types/<int:pk>/', views.TypeDetail.as_view()),
    path('seasons/', views.SeasonList.as_view()),
    path('seasons/<int:pk>/', views.SeasonDetail.as_view()),
    path('periods/', views.PeriodList.as_view()),
    path('periods/<int:pk>/', views.PeriodDetail.as_view()),
    path('weeks/', views.WeekList.as_view()),
    path('weeks/<int:pk>/', views.WeekDetail.as_view()),
    path('trainings/', views.TrainingList.as_view()),
    path('trainings/<int:pk>', views.TrainingDetail.as_view()),
    path('tasks/', views.TaskList.as_view()),
    path('tasks/<int:pk>', views.TaskDetail.as_view()),

]