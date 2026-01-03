import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdjectiveAdverbComponent } from './adjective-adverb.component';

describe('AdjectiveAdverbComponent', () => {
  let component: AdjectiveAdverbComponent;
  let fixture: ComponentFixture<AdjectiveAdverbComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdjectiveAdverbComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdjectiveAdverbComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
