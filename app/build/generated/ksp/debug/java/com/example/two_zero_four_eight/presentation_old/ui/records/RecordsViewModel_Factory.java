package com.example.two_zero_four_eight.presentation_old.ui.records;

import com.example.two_zero_four_eight.domain.repositories.RecordRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class RecordsViewModel_Factory implements Factory<RecordsViewModel> {
  private final Provider<RecordRepository> repositoryProvider;

  public RecordsViewModel_Factory(Provider<RecordRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public RecordsViewModel get() {
    return newInstance(repositoryProvider.get());
  }

  public static RecordsViewModel_Factory create(Provider<RecordRepository> repositoryProvider) {
    return new RecordsViewModel_Factory(repositoryProvider);
  }

  public static RecordsViewModel newInstance(RecordRepository repository) {
    return new RecordsViewModel(repository);
  }
}
