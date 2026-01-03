import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SpeakingListComponent } from './speaking-list.component';

describe('SpeakingListComponent', () => {
  let component: SpeakingListComponent;
  let fixture: ComponentFixture<SpeakingListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SpeakingListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SpeakingListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
