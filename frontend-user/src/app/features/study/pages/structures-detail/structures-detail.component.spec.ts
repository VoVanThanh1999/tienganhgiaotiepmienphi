import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StructuresDetailComponent } from './structures-detail.component';

describe('StructuresDetailComponent', () => {
  let component: StructuresDetailComponent;
  let fixture: ComponentFixture<StructuresDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StructuresDetailComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StructuresDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
