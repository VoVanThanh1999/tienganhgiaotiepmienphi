import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TensesComponent } from './tenses.component';

describe('TensesComponent', () => {
  let component: TensesComponent;
  let fixture: ComponentFixture<TensesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TensesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TensesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
