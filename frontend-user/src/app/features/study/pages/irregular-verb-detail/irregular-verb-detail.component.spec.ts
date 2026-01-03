import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IrregularVerbDetailComponent } from './irregular-verb-detail.component';

describe('IrregularVerbDetailComponent', () => {
  let component: IrregularVerbDetailComponent;
  let fixture: ComponentFixture<IrregularVerbDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ IrregularVerbDetailComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(IrregularVerbDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
