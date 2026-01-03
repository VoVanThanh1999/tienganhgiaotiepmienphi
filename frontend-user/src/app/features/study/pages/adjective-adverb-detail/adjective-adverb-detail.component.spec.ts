import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdjectiveAdverbDetailComponent } from './adjective-adverb-detail.component';

describe('AdjectiveAdverbDetailComponent', () => {
  let component: AdjectiveAdverbDetailComponent;
  let fixture: ComponentFixture<AdjectiveAdverbDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdjectiveAdverbDetailComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdjectiveAdverbDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
