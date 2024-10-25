package com.example.two_zero_four_eight.presentation_old.ui.game;

import com.example.two_zero_four_eight.domain.use_cases.CreateBoardGameUseCase;
import com.example.two_zero_four_eight.domain.use_cases.MoveNumbersUseCase;
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
public final class GameViewModel_Factory implements Factory<GameViewModel> {
  private final Provider<CreateBoardGameUseCase> boardGameUseCasesProvider;

  private final Provider<MoveNumbersUseCase> moveNumbersUseCaseProvider;

  public GameViewModel_Factory(Provider<CreateBoardGameUseCase> boardGameUseCasesProvider,
      Provider<MoveNumbersUseCase> moveNumbersUseCaseProvider) {
    this.boardGameUseCasesProvider = boardGameUseCasesProvider;
    this.moveNumbersUseCaseProvider = moveNumbersUseCaseProvider;
  }

  @Override
  public GameViewModel get() {
    return newInstance(boardGameUseCasesProvider.get(), moveNumbersUseCaseProvider.get());
  }

  public static GameViewModel_Factory create(
      Provider<CreateBoardGameUseCase> boardGameUseCasesProvider,
      Provider<MoveNumbersUseCase> moveNumbersUseCaseProvider) {
    return new GameViewModel_Factory(boardGameUseCasesProvider, moveNumbersUseCaseProvider);
  }

  public static GameViewModel newInstance(CreateBoardGameUseCase boardGameUseCases,
      MoveNumbersUseCase moveNumbersUseCase) {
    return new GameViewModel(boardGameUseCases, moveNumbersUseCase);
  }
}
