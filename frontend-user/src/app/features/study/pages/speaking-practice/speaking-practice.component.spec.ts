import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SpeakingPracticeComponent } from './speaking-practice.component';

describe('SpeakingPracticeComponent', () => {
  let component: SpeakingPracticeComponent;
  let fixture: ComponentFixture<SpeakingPracticeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SpeakingPracticeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SpeakingPracticeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
